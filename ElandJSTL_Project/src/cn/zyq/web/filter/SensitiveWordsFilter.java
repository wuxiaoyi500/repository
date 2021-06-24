package cn.zyq.web.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.ArrayList;
import java.util.List;

//敏感词汇过滤器
@WebFilter("/*")
public class SensitiveWordsFilter implements Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        //1.创建代理对象
        ServletRequest proxy = (ServletRequest) Proxy.newProxyInstance(req.getClass().getClassLoader(), req.getClass().getInterfaces(), new InvocationHandler() {
            @Override
            public Object invoke(Object o, Method method, Object[] objects) throws Throwable {
                //增强paramter方法
                //判断是否是paramter方法
                if (method.getName().equals("getParameter")){
                    //增强返回值
                    String value = (String) method.invoke(req,objects);
                    if (value != null && !"".equals(value)){
                        for (String str : list){
                            if (value.contains(str)){
                                //如果包含敏感字符，则替换成***
                                value = value.replaceAll(str,"***");
                            }
                        }
                    }
                    return value;
                }
                return method.invoke(req,objects);
            }
        });
        chain.doFilter(proxy, resp);
    }
    private List<String> list = new ArrayList<>();//敏感词汇集合
    public void init(FilterConfig config) throws ServletException {
        try {
            //加载文件，读取文件，将文件的每一行数据读取到集合中
            //1.获取文件的真实路径
            ServletContext context = config.getServletContext();
            String realPath = context.getRealPath("/WEB-INF/classes/SensitiveWords.txt");
            //流创建出来都是GBK编码的，如果和文件编码不符，就会乱码
            BufferedReader br = new BufferedReader(new FileReader(realPath));
            String line = null;
            while((line = br.readLine()) != null){
                list.add(line);
            }
            br.close();
            System.out.println(list);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}

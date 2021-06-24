package cn.zyq.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
//动态代理的基本实现步骤
public class ProxyTest {
    public static void main(String[] args) {
        //1.创建对象
        Lenovo lenovo = new Lenovo();
        //2.动态代理增强lenovo
        /*
        * 三个参数：
            1.类加载器：真实对象.getClass().getClassLoader()
            2.接口数组：真实对象.getClass().getInterfaces()
            3.处理器：new InvocationHandler()
        * */
        SaleComputer proxy_lenovo = (SaleComputer) Proxy.newProxyInstance(lenovo.getClass().getClassLoader(), lenovo.getClass().getInterfaces(), new InvocationHandler() {
            /*
             * 代理逻辑编写的方法：代理对象调用的所有方法都会触发该方法执行
             * 参数：
             *  1.provy:代理对象
             *  2.method:代理对象调用的方法被封装的对象
             *  3.objects:代理对象调用方法时传递的实际参数列表
             * */
            @Override
            public Object invoke(Object proxy, Method method, Object[] objects) throws Throwable {
//                System.out.println("该方法执行了");
//                System.out.println(objects[0]);
                //使用真实对象调用方法
//                Object obj = method.invoke(lenovo, objects);

                //判断是否时sale方法

                if (method.getName().equals("sale")){
                        //1.增强参数
                    double money = (double)objects[0];
                    money *= 0.85;
//                    Object obj = method.invoke(lenovo, money);
                    //2.再次增强
                    String obj = (String) method.invoke(lenovo, money);
                    return obj+"，还有鼠标垫，游戏鼠标，机械键盘，电竞耳机";
                }else {
                    Object obj = method.invoke(lenovo, objects);
                    return obj;
                }

            }
        });
        //2.调用方法
        String sale = proxy_lenovo.sale(8000);
        System.out.println(sale);
//        proxy_lenovo.show();



    }
}

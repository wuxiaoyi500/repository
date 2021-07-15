package cn.zyq.test;

import cn.zyq.domain.Person;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;

import java.io.File;

public class JacksonTest {
    //java对象转为JSON字符
    @Test
    public void test1() throws Exception{
        //1.创建Person对象
        Person person = new Person();
        person.setAge(18);
        person.setName("张三");
        person.setGender("male");
        //2.创建Jackson的核心对象
        ObjectMapper mapper = new ObjectMapper();
        //3.转换
        String json = mapper.writeValueAsString(person);
        System.out.println(json);
         /*

            转换方法：
                writeValue(参数1，obj):
                    参数1：
                        File：将obj对象转换为JSON字符串，并保存到指定的文件中
                        Writer：将obj对象转换为JSON字符串，并将json数据填充到字符输出流中
                        OutputStream：将obj对象转换为JSON字符串，并将json数据填充到字节输出流中
                writeValueAsString(obj):将对象转为json字符串

         */
        //将obj对象转换为JSON字符串，并保存到指定的文件中
        mapper.writeValue(new File("json.txt"),json);
        //将obj对象转换为JSON字符串，并将json数据填充到字符输出流中
    }
    @Test
    public void test2() throws Exception {

    }

}

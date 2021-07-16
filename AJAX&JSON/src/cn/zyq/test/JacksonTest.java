package cn.zyq.test;

import cn.zyq.domain.Person;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;

import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

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
        //writeValue，将数据写到d://json.txt文件中
        mapper.writeValue(new File("j.txt"),person);
        //writeValue.将数据关联到Writer中
        mapper.writeValue(new FileWriter("js.txt"),person);
    }
    @Test
    public void test2() throws Exception {
        Person person = new Person();
        person.setDate(new Date());
        person.setAge(18);
        person.setName("王舞");
        person.setGender("female");
        ObjectMapper mapper = new ObjectMapper();
        String p = mapper.writeValueAsString(person);
        System.out.println(p);
    }
    @Test
    //List对象转化
    public void test3() throws JsonProcessingException {
        Person p1 = new Person();
        p1.setDate(new Date());
        p1.setAge(18);
        p1.setName("王舞");
        p1.setGender("female");

        Person p2 = new Person();
        p2.setDate(new Date());
        p2.setAge(19);
        p2.setName("李斯");
        p2.setGender("male");

        Person p3 = new Person();
        p3.setDate(new Date());
        p3.setAge(17);
        p3.setName("赵流");
        p3.setGender("female");

        ArrayList<Person> list = new ArrayList<Person>();
        list.add(p1);
        list.add(p2);
        list.add(p3);

        ObjectMapper mapper = new ObjectMapper();
        String string = mapper.writeValueAsString(list);
        System.out.println(string);
    }
    @Test
    //map对象转换
    public void test4() throws Exception{
        HashMap<String, Object> map = new HashMap<>();
        map.put("name","张散");
        map.put("age","19");
        map.put("gender","男");
        ObjectMapper mapper = new ObjectMapper();
        String json = mapper.writeValueAsString(map);
        System.out.println(json);
    }
    @Test
    //JSON字符串转为Java对象
    public void test5() throws Exception{
        String json = "{\"name\":\"张三\",\"age\":18,\"gender\":\"男\"}";
        ObjectMapper mapper = new ObjectMapper();
        Person person = mapper.readValue(json, Person.class);
        System.out.println(person);
    }

}

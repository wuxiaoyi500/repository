package cn.zyq.jedis.test;

import org.junit.Test;
import redis.clients.jedis.Jedis;

/*
* Jedis测试类
* */
public class JedisTest {
    //快速入门
    @Test
    public void test1(){
        //1.获取连接
        Jedis jedis = new Jedis("localhost", 6379);
        //2.操作
        jedis.set("username", "zhangsan");
        //3.关闭
        jedis.close();
    }
}

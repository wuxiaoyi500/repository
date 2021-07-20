package cn.zyq.jedis.test;

import cn.zyq.jedis.util.JedisPoolUtil;
import org.junit.Test;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * jedis的测试类
 */
public class JedisTest {
    /**
     * 快速入门
     */
    @Test
    //1.基本操作
    public void Test1(){
        //1.建立连接
        Jedis jedis = new Jedis("localhost", 6379);
        //2.操作
        jedis.del("username");
        //3.关闭连接
        jedis.close();
    }
    @Test
    //2.String数据结构操作
    public void Test2(){
        //1.获取连接
        Jedis jedis = new Jedis();//如果使用空参构造，默认值 "localhost",6379端口
        //2.操作
        //存储
        jedis.set("username","zhangsan");
        //获取
        String username = jedis.get("username");
        System.out.println(username);
        //可以使用setex()方法存储可以指定过期时间的 key value
        jedis.setex("activecode",20,"hehe");//将activecode：hehe键值对存入redis，并且20秒后自动删除该键值对
        jedis.close();
    }
    @Test
    //hash数据结构操作
    public void Test3(){
        Jedis jedis = new Jedis();
        jedis.hset("user","name","wangwu");
        jedis.hset("user","age","19");
        jedis.hset("user","gender","female");
        String name = jedis.hget("user", "name");
        System.out.println(name);
        Map<String, String> user = jedis.hgetAll("user");
        Set<String> keySet = user.keySet();
        for(String key : keySet){
            String value = user.get(key);
            System.out.println(key + ":" + value);
        }
        jedis.close();
    }
    @Test
    //list数据结构操作
    public void Test4(){
        Jedis jedis = new Jedis();
        jedis.lpush("ml","a","b","c","d");
        jedis.rpush("ml","a","b","c","d");
        List<String> ml = jedis.lrange("ml", 0, -1);
        System.out.println(ml);
        jedis.close();
    }
    @Test
    //set操作
    public void Test5(){
        Jedis jedis = new Jedis();
        jedis.sadd("language","java","c++","php","python","golang");
        Set<String> language = jedis.smembers("language");
        System.out.println(language);
        jedis.close();
    }
    @Test
    //sortedset操作
    public void Test6(){
        Jedis jedis = new Jedis();
        jedis.zadd("ms",1,"盖伦");
        jedis.zadd("ms",2,"贾克斯");
        jedis.zadd("ms",2,"金克斯");
        Set<String> ms = jedis.zrange("ms", 0, -1);
        System.out.println(ms);
        jedis.close();
    }
    @Test
    //jedis 连接池对象
    public void Test7(){
        //1.创建配置对象
        JedisPoolConfig jedisPoolConfig = new JedisPoolConfig();
        jedisPoolConfig.setMaxIdle(50);
        jedisPoolConfig.setMaxTotal(50);
        //2.创建连接池对象
        JedisPool jedisPool = new JedisPool(jedisPoolConfig, "localhost", 6379);
        //3.获取连接
        Jedis jedis = jedisPool.getResource();
        //4.使用
        jedis.set("username","李青");
        String username = jedis.get("username");
        System.out.println(username);
        //5.关闭连接
        jedis.close();
    }
    @Test
    //连接池工具类使用
    public void Test8(){
        Jedis jedis = JedisPoolUtil.getJedisPool();
        jedis.set("name","盲仔");
        String name = jedis.get("name");
        System.out.println(name);
        jedis.close();
    }
}

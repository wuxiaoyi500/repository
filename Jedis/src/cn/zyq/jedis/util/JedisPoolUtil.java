package cn.zyq.jedis.util;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

//Jedis连接池工具类
public class JedisPoolUtil {
    private static JedisPool jedisPool;
    static {
        //加载配置文件
        InputStream is = JedisPoolUtil.class.getClassLoader().getResourceAsStream("Jedis.properties");
        Properties properties = new Properties();
        //关联文件

        try {
            properties.load(is);
        } catch (IOException e) {
            e.printStackTrace();
        }
        JedisPoolConfig config = new JedisPoolConfig();
        config.setMaxTotal(Integer.parseInt(properties.getProperty("MaxTotal")));
        config.setMaxIdle(Integer.parseInt(properties.getProperty("MaxIdle")));
        jedisPool = new JedisPool(config,properties.getProperty("host"),Integer.parseInt(properties.getProperty("port")));

    }
    public static Jedis getJedisPool(){
        return jedisPool.getResource();
    }
}

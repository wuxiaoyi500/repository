package cn.zyq.jedis.service.impl;

import cn.zyq.jedis.dao.ProvinceDao;
import cn.zyq.jedis.dao.imp.ProvinceDaoImp;
import cn.zyq.jedis.domain.Province;
import cn.zyq.jedis.service.ProvinceService;
import cn.zyq.jedis.util.JedisPoolUtil;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import redis.clients.jedis.Jedis;

import java.util.List;

public class ProvinceServiceImpl implements ProvinceService {
    private ProvinceDao dao = new ProvinceDaoImp();
    @Override
    public List<Province> findAll() {
        return dao.findAll();
    }

    @Override
    public String findAllJson() {
        //获取Jedis
        Jedis jedis = JedisPoolUtil.getJedisPool();
        //从reids中查询
        String provinceJson = jedis.get("province");
        //判断redis中数据是否存在
        if (provinceJson == null || provinceJson.length() == 0){
            System.out.println("redis中数据不存在，从数据库获取");
            List<Province> list = dao.findAll();
            ObjectMapper mapper = new ObjectMapper();
            try {
                provinceJson = mapper.writeValueAsString(list);
                //存入redis
                jedis.set("province",provinceJson);
            } catch (JsonProcessingException e) {
                e.printStackTrace();
            }
        }else {
            System.out.println("redis中数据存在，从redis中获取");
        }
        jedis.close();
        return provinceJson;
    }
}

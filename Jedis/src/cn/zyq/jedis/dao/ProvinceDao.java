package cn.zyq.jedis.dao;

import cn.zyq.jedis.domain.Province;

import java.util.List;

public interface ProvinceDao {
    public List<Province> findAll();
}

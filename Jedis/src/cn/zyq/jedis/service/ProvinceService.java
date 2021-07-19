package cn.zyq.jedis.service;

import cn.zyq.jedis.domain.Province;

import java.util.List;

public interface ProvinceService {
    public List<Province> findAll();
    public String findAllJson();
}

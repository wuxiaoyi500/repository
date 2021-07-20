package cn.zyq.jedis.service.impl;

import cn.zyq.jedis.dao.ProvinceDao;
import cn.zyq.jedis.dao.imp.ProvinceDaoImp;
import cn.zyq.jedis.domain.Province;
import cn.zyq.jedis.service.ProvinceService;

import java.util.List;

public class ProvinceServiceImpl implements ProvinceService {
    private ProvinceDao pd = new ProvinceDaoImp();
    @Override
    public List<Province> findAll() {
        return pd.findAll();
    }

    @Override
    public String findAllJson() {
        return null;
    }
}

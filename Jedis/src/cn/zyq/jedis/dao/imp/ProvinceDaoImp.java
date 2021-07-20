package cn.zyq.jedis.dao.imp;

import cn.zyq.jedis.dao.ProvinceDao;
import cn.zyq.jedis.domain.Province;
import cn.zyq.jedis.util.JDBCUtil;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

public class ProvinceDaoImp implements ProvinceDao {
    @Override
    public List<Province> findAll() {
        JdbcTemplate template = new JdbcTemplate(JDBCUtil.getDataSource());
        String sql = "select * from province";
        List<Province> list = template.query(sql, new BeanPropertyRowMapper<Province>(Province.class));
        return list;
    }
}

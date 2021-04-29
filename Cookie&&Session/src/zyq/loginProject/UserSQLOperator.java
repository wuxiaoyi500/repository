package zyq.loginProject;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

//操作数据库中User表的类
public class UserSQLOperator {
    //声明Template对象
    private JdbcTemplate template = new JdbcTemplate(druidUtil.getDataSource());
    public UserData login(UserData loginUserData){
        String sql = "select * from user_data where username = ? and password = ?";
        template.queryForObject(sql,
                new BeanPropertyRowMapper<UserData>(UserData.class),
                loginUserData.getUsername(),loginUserData.getPassword()
                );

        return null;
    }
}

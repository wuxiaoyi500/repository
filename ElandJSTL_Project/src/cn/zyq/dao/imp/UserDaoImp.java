package cn.zyq.dao.imp;

import cn.zyq.dao.UserDao;
import cn.zyq.domain.User;
import cn.zyq.util.JDBCUtil;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

public class UserDaoImp implements UserDao {
    private JdbcTemplate template = new JdbcTemplate(JDBCUtil.getDataSource());
    @Override
    public List<User> findAll() {
        //通过JDBC操作数据库
        String sql = "select * from user";
        List<User> users = template.query(sql, new BeanPropertyRowMapper<User>(User.class));
        return users;
    }

    @Override
    public User login(String username,String password) {
        try {
            String sql = "select * from user where username = ? and password = ?";
            User user = template.queryForObject(sql,new BeanPropertyRowMapper<User>(User.class),username,password);
            return  user;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public void add(User user) {
        //1.定义SQL
        String sql = "insert into user values(null,?,?,?,?,?,?,null,null)";
        //2.执行sql
        template.update(sql,user.getName(),user.getGender(),user.getAge(),user.getAddress(),user.getQq(),user.getEmail());
    }

    @Override
    public void delete(String id) {
        String sql = "delete from user where id = ?";
        template.update(sql,id);
    }


    @Override
    public User findUserById(int id) {
        String sql = "select * from user where id = ?";
        return template.queryForObject(sql,new BeanPropertyRowMapper<User>(User.class),id);
    }

    @Override
    public void changeUser(User user) {
        String sql = "update user set name=?,gender=?,age=?,address=?,qq=?,email=? where id =?";
        template.update(sql,user.getName(),user.getGender(),user.getAge(),user.getAddress(),user.getQq(),user.getEmail(),user.getId());
    }

    @Override
    public void delSelected(String[] ids) {
        String sql = "delete from user where id = ?";
        for (String id : ids) {
            template.update(sql, Integer.parseInt(id));
        }
    }

    @Override
    public int findTotalCount() {
        String sql = "select count(*) from user";
        return template.queryForObject(sql,Integer.class);
    }

    @Override
    public List<User> findByPage(int start, int rows) {
        String sql = "select * from user limit ? , ? ";
        return template.query(sql,new BeanPropertyRowMapper<User>(User.class),start,rows);
    }
}

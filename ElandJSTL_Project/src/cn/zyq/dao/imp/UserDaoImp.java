package cn.zyq.dao.imp;

import cn.zyq.dao.UserDao;
import cn.zyq.domain.User;
import cn.zyq.util.JDBCUtil;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

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
    public int findTotalCount(Map<String, String[]> condition) {
        //1.定义模板，初始化sql
        String sql = "select count(*) from user where 1 = 1 ";
        //拼接sql语句
        StringBuilder sb = new StringBuilder(sql);
        //2.遍历map
        Set<String> keySet = condition.keySet();
        //定义参数的集合
        ArrayList<Object> params = new ArrayList<Object>();
        for (String key : keySet){
            //排除分页条件参数
            if ("currentPage".equals(key) || "rows".equals(key)){
                continue;
            }
            String value = condition.get(key)[0];
//            System.out.println(value);
            //判断value是否有值
            if (value != null && !value.equals("")){
                sb.append(" and "+key+" like ? ");//注意语句前后要加空格
                params.add("%"+value+"%");// ？ 条件的值
            }
        }
//        System.out.println(sb.toString());
//        System.out.println(params);
        return template.queryForObject(sb.toString(),Integer.class,params.toArray());
    }

    @Override
    public List<User> findByPage(int start, int rows, Map<String, String[]> condition) {
        String sql = "select * from user where 1 = 1 ";
        StringBuilder sb = new StringBuilder(sql);
        //2.遍历map
        Set<String> keySet = condition.keySet();
        //定义参数的集合
        List<Object> params = new ArrayList<Object>();
        for (String key : keySet){
            //排除分页条件参数
            if ("currentPage".equals(key) || "rows".equals(key)){
                continue;
            }
            String value = condition.get(key)[0];
//            System.out.println(value);
            //判断value是否有值
            if (value != null && !value.equals("")){
                sb.append(" and "+key+" like ? ");//注意语句前后要加空格
                params.add("%"+value+"%");// ？ 条件的值
            }
        }
        sb.append(" limit ? , ? ");
        params.add(start);
        params.add(rows);
        sql = sb.toString();
        return template.query(sql,new BeanPropertyRowMapper<User>(User.class),params.toArray());
    }
}

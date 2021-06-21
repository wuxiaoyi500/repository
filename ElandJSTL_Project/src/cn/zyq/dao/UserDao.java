package cn.zyq.dao;
/*
    用户操作的接口
*/

import cn.zyq.domain.User;

import java.util.List;
import java.util.Map;

public interface UserDao {
    List<User> findAll();
    User login(String username,String password);

    void add(User user);

    void delete(String id);

    User findUserById(int id);

    void changeUser(User user);

    void delSelected(String[] ids);

    int findTotalCount(Map<String, String[]> condition);
    //分页查询每页记录
    List<User> findByPage(int start, int rows, Map<String, String[]> condition);
}

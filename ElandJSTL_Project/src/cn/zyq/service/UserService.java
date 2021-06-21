package cn.zyq.service;

import cn.zyq.domain.PageBean;
import cn.zyq.domain.User;

import java.util.List;
import java.util.Map;

/*
* 用户表业务接口
* */
public interface UserService {
    //查询功能
    List<User> findAll();
    //登录
    User login(User user);
    //添加
    void addUser(User user);
    //删除
    void deleteUser(String id);
    //通过id查询
    User findUserById(String id);
    //修改
    void changeUser(User user);
    //选定删除
    void delSelected(String[] uid);
    //分页条件查询
    PageBean<User> findUserByPage(String _currentPage, String _rows, Map<String, String[]> condition);
}

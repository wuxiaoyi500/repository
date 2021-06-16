package cn.zyq.service.impl;

import cn.zyq.dao.UserDao;
import cn.zyq.dao.imp.UserDaoImp;
import cn.zyq.domain.PageBean;
import cn.zyq.domain.User;
import cn.zyq.service.UserService;

import java.util.List;

public class UserServiceImp implements UserService {
    private UserDao dao = new UserDaoImp();
    @Override
    public List<User> findAll() {
        //通过dao获取数据
        return dao.findAll();
    }

    @Override
    public User login(User user) {
        return dao.login(user.getUsername(),user.getPassword());
    }

    @Override
    public void addUser(User user) {
        dao.add(user);
    }

    @Override
    public void deleteUser(String id) {
        dao.delete(id);
    }

    @Override
    public User findUserById(String id) {
        return dao.findUserById(Integer.parseInt(id));
    }

    @Override
    public void changeUser(User user) {
        dao.changeUser(user);
    }

    @Override
    public void delSelected(String[] ids) {
        if (ids !=null && ids.length>0){
            dao.delSelected(ids);
        }
    }

    @Override
    public PageBean<User> findUserByPage(String _currentPage, String _rows) {
        //转换类型
        int currentPage = Integer.parseInt(_currentPage);
        int rows = Integer.parseInt(_rows);
        //1.创建空的pageBean对象
        PageBean<User> pb = new PageBean<User>();
        //2.设置参数
        pb.setCurrentPages(currentPage);
        pb.setRows(rows);
        //3.调用dao查询总记录数
        int totalCount = dao.findTotalCount();
        pb.setTotalCount(totalCount);
        //4.调用dao查询List集合
        //计算开始的记录索引
        int start = (currentPage - 1) * rows;
        List<User> list = dao.findByPage(start,rows);
        pb.setList(list);
        //5.计算总页码
        int totalPage = (totalCount % rows)  == 0 ? (totalCount/rows) : (totalCount/rows) + 1;
        pb.setTotalPage(totalPage);
        return pb;
    }
}

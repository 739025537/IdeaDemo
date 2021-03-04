package com.javacto.day002.dao;

import com.javacto.day002.po.User;
import com.javacto.day002.util.PageInfo;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public interface UserDao {
    /**
     * 添加方法
     * @param user
     * @return
     */
    public  int addUser(User user) throws Exception;
    /**
     * 删除
     * @param id
     * @return
     */
    public  int deleteUser(int id) throws Exception;
    /**
     * 根据id查询
     * @param id
     * @return
     */
    public  User findUserById(int id);
    /**
     * 修改方法
     * @param user
     * @return
     */
    public  int updateUser(User user);
    /**
     * 查询所有
     * @return
     */
    public List<User> querAll();

    public boolean login(String name1, String pwd1);

    /**
     * 分页查询
     * @return
     */
    //public  List<User> queryAllPage(int curPageNo,int pageSize,User user);
    public  List<User> queryAllPage(PageInfo pageInfo, User user);

    /**
     * 查询总条数
     */
    public  int getTotalCount(User user);

    /**
     * 查询用户是否存在
     */
    public boolean findUserByName(String name) throws SQLException;
}

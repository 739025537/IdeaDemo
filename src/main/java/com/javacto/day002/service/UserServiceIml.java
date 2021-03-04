package com.javacto.day002.service;

import com.javacto.day002.dao.UserDao;
import com.javacto.day002.dao.UserDaoIml;
import com.javacto.day002.po.User;
import com.javacto.day002.util.PageInfo;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * describe  业务层实现类
 * implements UserService 很多同学忘记 实现
 *
 *
 * 作者：
 */

public class UserServiceIml implements UserService {
    //需要调用dao层 创建对象  接口  变量名  = new 实现类();
    private UserDao userDaoSbq = new UserDaoIml();
    /**
     * 添加方法
     * @param user
     * @return
     */
    public  int addUser(User user) throws Exception{
        //以后实际开发这里会有业务逻辑代码，现在没有写
        int num = userDaoSbq.addUser(user);
        return  num;
    }

    /**
     * 删除
     * @param id
     * @return
     */
    public  int deleteUser(int id) throws Exception{
        return  userDaoSbq.deleteUser(id);
    }

    /**
     * 根据id查询
     * @param id
     * @return
     */
    public User findUserById(int id){

        return  userDaoSbq.findUserById(id);
    }

    /**
     * 修改方法
     * @param user
     * @return
     */
    public  int updateUser(User user){

        return  userDaoSbq.updateUser(user);
    }
    /**
     * 查询所有
     * @return
     */
    public List<User> querAll()throws Exception{
        return  userDaoSbq.querAll();
    }

    public boolean login(String name1, String pwd1) throws Exception {
//        boolean flag=false;
//        ResultSet resultSet=userDaoSbq.login(name1, pwd1);
//        while (resultSet.next()){
//            flag=true;
//        }
        return userDaoSbq.login(name1, pwd1);
    }
    /**
     * 分页查询
     * 请各位同学写完了一定测试下，我就不测试了
     * @return
     */
    //public  List<User> queryAllPage(int curPageNo,int pageSize,User user);
    public  List<User> queryAllPage(PageInfo pageInfo, User user){

        return userDaoSbq.queryAllPage(pageInfo,user);
    }

    /**
     * 查询总条数
     */
    public  int getTotalCount(User user){
        return  userDaoSbq.getTotalCount(user);
    }

    /**
     * 查询用户是否存在
     */
    public boolean findUserByName(String name) throws SQLException {

        return userDaoSbq.findUserByName(name);
    };
}

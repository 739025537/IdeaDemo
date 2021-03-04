package com.javacto.day002.test;

import com.javacto.day002.action.UserAction;
import com.javacto.day002.dao.UserDao;
import com.javacto.day002.po.User;
import com.javacto.day002.service.UserService;
import com.javacto.day002.service.UserServiceIml;

public class UserActionTest {
    public static void main(String[] args) throws Exception {
        //创建对象
//        UserAction userAction = new UserAction();
//        User user = new User();
        UserService userService = new UserServiceIml();
        //给user属性赋值
//        user.setId(6);
//        user.setName("张三");
//        user.setPwd("123456");

        //System.out.println(((UserServiceIml) userService).login("张三","123456"));
        //调用控制层的添加方法
        //userAction.addUser(user);
        //userAction.deleteUser(5);
        //userAction.updateUser(3,"刚刚修");
//        UserDaoIml userDaoIml=new UserDaoIml();
//      List<User> list= userDaoIml.querAll();
//        for (User u:list){
//            System.out.println(u);
//        }
boolean flag=userService.findUserByName("张三");
        System.out.println(flag);
}}
//测试类->控制层（action)->业务层（service)->Dao层(实现类)
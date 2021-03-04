package com.javacto.day002.action;

import com.javacto.day002.po.User;
import com.javacto.day002.service.UserService;
import com.javacto.day002.service.UserServiceIml;

public class UserAction {
    //控制层需要调用  业务层的代码
    private UserService userService = new UserServiceIml();

    //以后控制 不是这样写的，因为后面课程还没有讲到，所以今天就这样写

    /**
     * 添加方法
     * @param user
     * @return
     */
    public  String addUser(User user) throws Exception{
        int num =userService.addUser(user);
        System.out.println(num);
        if(num>0){
            System.out.println("添加成功2");
        }
        return "userList";//这个你不要看，只是暂时这样写
    }
    public  String deleteUser(int id) throws Exception{
        int num =userService.deleteUser(id);
        System.out.println(num);
        if(num>0){
            System.out.println("删除成功2");
        }
        return "userList";//这个你不要看，只是暂时这样写
    }
//    public List<User> findUserById(int id) throws Exception{
//        User list =userService.findUserById(id);
//        System.out.println(num);
//
//        return list;//这个你不要看，只是暂时这样写
//    }
    public  String  updateUser(int id,String name) {
        //1.根据用查询数据
        User user1=userService.findUserById(id);
        //2.修改属性值
        user1.setName(name);
        //3.调用修改方法.
        int num = userService.updateUser(user1);
        if(num>0){
        System.out.println("修改成功2");
    }
    return "userList";//这个你不要看，只是暂时这样写
}

}

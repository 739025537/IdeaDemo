package com.javacto.day002.control;

import com.javacto.day002.po.User;
import com.javacto.day002.service.UserService;
import com.javacto.day002.service.UserServiceIml;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/userquerylist.do")
public class UserQueryServlet extends HttpServlet {
    protected void doGet(HttpServletRequest reqSBQ, HttpServletResponse respSBQ) throws ServletException, IOException {
        //如果提交方式是get 我也调用doPost方法  如果使用servlet通常就这样写
       doPost(reqSBQ, respSBQ);//调用本类中的方法
    }


    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        //处理编码格式，必需在最前面,只要是servlet 大家在最前面加上这两句就OK。
        resp.setContentType("text/html;charset=UTF-8");//响映编码
        //处理请求编码格式
        req.setCharacterEncoding("UTF-8");
        //1.创建服务层对象
        UserService userService=new UserServiceIml();
        //创建集合用于接收User集合
        List<User> list=null;

        try {
            list=userService.querAll();
        } catch (Exception e) {
            e.printStackTrace();
        }
        //2.将值存于HttpServletRequest作用域中
        req.setAttribute("sbqd",list);

        //3.徐、、必须通过转发得方式
        req.getRequestDispatcher("/userlist.jsp").forward(req,resp);
    }
}
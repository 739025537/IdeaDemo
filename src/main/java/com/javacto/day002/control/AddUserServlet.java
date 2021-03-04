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
import java.io.PrintWriter;

@WebServlet("/addUser.do")
public class AddUserServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //处理编码格式，必需在最前面
        resp.setContentType("text/html;charset=UTF-8");
        PrintWriter out= resp.getWriter();
        //out.println("我来了");
        //中文是乱码，后面讲
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");
        //得到login.jsp input 中的值  必需通过 name="sbqUname"
        int uid= Integer.parseInt(req.getParameter("userId"));
        String name= req.getParameter("userName");
        String pwd= req.getParameter("pwd");

        //兴趣爱好是数组
        Object likes[]=req.getParameterValues("likes");

        //得到这些值，大家可以，去调用业务层，
        //这里我现在不写，这是大家的作业，
        //1.创建业务层对象  我没有写完，是给大家的作业
        UserService userService = new UserServiceIml();

        User user=new User();
        user.setId(uid);
        user.setName(name);
        user.setPwd(pwd);
        try {
         int num= userService.addUser(user);
         if (num>0){
             //转发
             req.getRequestDispatcher("/userquerylist.do").forward(req,resp);
         }else {
             out.println("添加失败");
         }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

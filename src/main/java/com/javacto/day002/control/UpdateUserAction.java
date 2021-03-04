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

@WebServlet("/updateUser.do")
public class UpdateUserAction extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest reqSBQ, HttpServletResponse respSBQ) throws ServletException, IOException {
        //如果提交方式是get 我也调用doPost方法  如果使用servlet通常就这样写
        doPost(reqSBQ, respSBQ);//调用本类中的方法
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        //1.处理编码格式
        //处理编码格式，必需在最前面,只要是servlet 大家在最前面加上这两句就OK。
        resp.setContentType("text/html;charset=UTF-8");//响映编码
        //处理请求编码格式
        req.setCharacterEncoding("UTF-8");
        //获取参数
        String name=req.getParameter("userName");
        String pwd=req.getParameter("pwd");

        //修改必须获取ID
        String idstr=req.getParameter("id");
        Integer id=Integer.parseInt(idstr);

        //值存入user对象
        User user=new User();
        user.setId(id);
        user.setName(name);
        user.setPwd(pwd);

        //调用业务代码
        UserService userService=new UserServiceIml();
        int i=userService.updateUser(user);

        //判断是否成功
        if (i>0){
            req.getRequestDispatcher("/userquerylist.do").forward(req, resp);
        }else {
            resp.sendRedirect("/JSPDemoDay002_war_exploded/login.jsp");
        }
    }
}
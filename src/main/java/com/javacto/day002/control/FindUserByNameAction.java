package com.javacto.day002.control;

import com.javacto.day002.service.UserService;
import com.javacto.day002.service.UserServiceIml;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

@WebServlet("/findUserByName")
public class FindUserByNameAction extends HttpServlet {
    protected void doGet(HttpServletRequest reqSBQ, HttpServletResponse respSBQ) throws ServletException, IOException {
        //如果提交方式是get 我也调用doPost方法  如果使用servlet通常就这样写
        doPost(reqSBQ, respSBQ);//调用本类中的方法
    }


    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        //处理编码格式，必需在最前面,只要是servlet 大家在最前面加上这两句就OK。
        resp.setContentType("text/html;charset=UTF-8");//响映编码
        //处理请求编码格式
        req.setCharacterEncoding("UTF-8");
        PrintWriter out = resp.getWriter();
        //获取前端请求得参数
        String name=req.getParameter("userName");
        //调用业务层代码
        UserService userService=new UserServiceIml();
        try {
            boolean b=userService.findUserByName(name);
            //判断
            if (b){
                out.println("1");
            }else {
                out.println("0");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}

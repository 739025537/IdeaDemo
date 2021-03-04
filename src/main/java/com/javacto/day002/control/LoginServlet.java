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

@WebServlet("/login.do")
public class LoginServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest reqSbq, HttpServletResponse respSbq) throws ServletException, IOException, IOException {

        //处理编码格式，必需在最前面
        respSbq.setContentType("text/html;charset=UTF-8");
        PrintWriter out= respSbq.getWriter();
        //out.println("我来了");
        //中文是乱码，后面讲
        reqSbq.setCharacterEncoding("UTF-8");
        respSbq.setCharacterEncoding("UTF-8");
        //得到login.jsp input 中的值  必需通过 name="sbqUname"
        String name= reqSbq.getParameter("sbqUname");
        String pwd= reqSbq.getParameter("pwd");

        //兴趣爱好是数组
        Object likes[]=reqSbq.getParameterValues("likes");

        //得到这些值，大家可以，去调用业务层，
        //这里我现在不写，这是大家的作业，
        //1.创建业务层对象  我没有写完，是给大家的作业
         UserService userService = new UserServiceIml();

        //2.调用方法  我没有写完，是给大家的作业
        try {
         boolean b= ((UserServiceIml) userService).login(name,pwd);
         if (b==false){
             //登陆失败再转到登陆页面  重定向
             //respSbq.sendRedirect("/JSPDemoDay002/web/login.jsp");;
             //转发
             reqSbq.getRequestDispatcher("/login.jsp").forward(reqSbq,respSbq);
         }else {
             reqSbq.getRequestDispatcher("/userPageQuery.do").forward(reqSbq,respSbq);
         }
        } catch (Exception e) {
            e.printStackTrace();
        }


        //目前大家就是把流程跑通了

    }
}

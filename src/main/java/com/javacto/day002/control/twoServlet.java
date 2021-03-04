package com.javacto.day002.control;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class twoServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //获取参数 固定写法，不用背，也不用记
        //设置统一编码
        String encoding= this.getServletContext().getInitParameter("sbqEncoding");


        //处理编码格式，必需在最前面
        resp.setContentType("text/html;charset=UTF-8");
        PrintWriter out = resp.getWriter();

        //得到初始化值  我的参数不想定义在代码中
        String sbq= getInitParameter("sbqStraaa");
        out.println(sbq);

        out.println("1111");
    }
}

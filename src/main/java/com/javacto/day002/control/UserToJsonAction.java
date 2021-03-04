package com.javacto.day002.control;

import com.javacto.day002.po.User;
import net.sf.json.JSONObject;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;

@WebServlet("/userToJson.do")
public class UserToJsonAction {
    protected void doGet(HttpServletRequest reqSBQ, HttpServletResponse respSBQ) throws ServletException, IOException {
        //如果提交方式是get 我也调用doPost方法  如果使用servlet通常就这样写
        doPost(reqSBQ, respSBQ);//调用本类中的方法
    }


    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException, IOException {

        //1.处理编码格式
        //处理编码格式，必需在最前面,只要是servlet 大家在最前面加上这两句就OK。
        resp.setContentType("text/html;charset=UTF-8");//响映编码
        //处理请求编码格式
        req.setCharacterEncoding("UTF-8");
        PrintWriter out = resp.getWriter();

        /**
         *  这是一个对象，我需要把对象转为json格式
         *  1.必需导入所需jar 包，， tomcat  lib下也要导入目前
         */
        User user001=new User();
        user001.setId(1);
        user001.setName("战士");
        user001.setPwd("123");

        //2.对象转为json格式
        JSONObject jsonObject = JSONObject.fromObject(user001);

        System.out.println(jsonObject); //out.println(jsonObject);


        //这是一个集合
//        User002 user002 = new User002(2,"李四");
//        User002 user003 = new User002(3,"好人");
//
//        List<User002> list = new ArrayList<User002>();
//        list.add(user002);
//        list.add(user003);
//
//        //集合转json格式
//        JSONArray jsonArray = JSONArray.fromObject(list);
//        out.println(jsonArray);


    }
}

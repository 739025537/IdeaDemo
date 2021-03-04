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

@WebServlet("/findByUserId.do")
public class FindUserByIdAction extends HttpServlet {
    protected void doGet(HttpServletRequest reqSBQ, HttpServletResponse respSBQ) throws ServletException, IOException {
        //如果提交方式是get 我也调用doPost方法  如果使用servlet通常就这样写
        doPost(reqSBQ, respSBQ);//调用本类中的方法
    }


    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        //处理编码格式，必需在最前面,只要是servlet 大家在最前面加上这两句就OK。
        resp.setContentType("text/html;charset=UTF-8");//响映编码
        //处理请求编码格式
        req.setCharacterEncoding("UTF-8");

        //获取请求参数
        String idstr=req.getParameter("id");
        Integer id=Integer.parseInt(idstr);

        //1.创建服务层对象
        UserService userService=new UserServiceIml();
        //接收User集合
        User user=userService.findUserById(id);
        //判断是否添加成功
        if (user!=null){
            //必需把user 存入 HttpServletRequest
            req.setAttribute("user",user);
            //这里必需通过转发到  updateUser.jsp
            req.getRequestDispatcher("/updateUser.jsp").forward(req, resp);
        }else {

        }
    }
}

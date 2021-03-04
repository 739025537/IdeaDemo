package com.javacto.day002.control;



import com.javacto.day002.po.User;
import com.javacto.day002.service.UserService;
import com.javacto.day002.service.UserServiceIml;
import com.javacto.day002.util.PageInfo;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;


/**
 * describe
 * 作者：曾昭武
 */
@WebServlet("/userPageQuery.do")
public class UserPageAction extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest reqSBQ, HttpServletResponse respSBQ) throws ServletException, IOException {
        //如果提交方式是get 我也调用doPost方法  如果使用servlet通常就这样写
        doPost(reqSBQ,respSBQ);//调用本类中的方法
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        //1.处理编码格式
        //处理编码格式，必需在最前面,只要是servlet 大家在最前面加上这两句就OK。
        resp.setContentType("text/html;charset=UTF-8");//响映编码
        //处理请求编码格式
        req.setCharacterEncoding("UTF-8");

        //2.必需获取当前页
        String curPageNoStr = req.getParameter("curPageNo");
        Integer curPageNo=1;//当前页默认设置为1
        if(null!=curPageNoStr){
            curPageNo=Integer.parseInt(curPageNoStr);
        }
        //3.现在必需把当前面存入PageInfo对象,因为调用方法传的是对象
        PageInfo pageInfo = new PageInfo();
        pageInfo.setCurPageNo(curPageNo);
        //pageInfo.setPageSize(2);//我现在设置每页只显示2条

        //3.调用业务代码
        UserService userService  = new UserServiceIml();
        List<User> sbqList= userService.queryAllPage(pageInfo,null);

        //查询总条数
        int totalCount = userService.getTotalCount(null);
        //再把 totalCount 存入  PageInfo对象
        pageInfo.setTotalCount(totalCount);

        //4.必需要存
        req.setAttribute("list2",sbqList);

        // 必需把  pageInfo 存入到HttpServletRequest  因为页面需要获取这个值
        req.setAttribute("sbqPage",pageInfo);

        //转发
        req.getRequestDispatcher("/userlist2.jsp").forward(req,resp);



    }
}


package com.bh.crms.servlet;

import com.bh.crms.pojo.Crms;
import com.bh.crms.service.UpdateService;
import com.bh.crms.util.JdbcUtil;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.ParseException;
import java.util.Date;

@WebServlet(urlPatterns = "/update")
public class UpdateServlet extends HttpServlet {
    @Autowired
    private UpdateService updateService;

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        /**
         * 1.封装对象
         * 2.添加id
         * 3.调用service
         * 4.成功信息
         * 5.跳转页面
         */
        //获取参数
        String cname1 = req.getParameter("cname");
        String gender = req.getParameter("gender");
        String birthday = req.getParameter("birthday");
        //使用工具类将时间字符串转化为日期对象
        Date date1 = null;
        try {
            date1 = JdbcUtil.stringToDate(birthday);
        } catch (ParseException e) {
            System.out.println("转化日期对象失败");
        }
        //获取id
        String id = req.getParameter("id");
        String cellphone = req.getParameter("cellphone");
        String email = req.getParameter("email");
        String description = req.getParameter("description");

        //构造方法
        Crms crms = new Crms(id,cname1,gender,date1,cellphone,email,description);
        //调用方法传递修改对象
        int add = updateService.updateById(crms);
        //根据返回值判断成功与否
        if(1 == add){
            req.setAttribute("msg","修改成功");
        }else {
            req.setAttribute("msg","修改失败");
        }
        //跳转页面
        req.getRequestDispatcher("msg.jsp").forward(req,resp);
    }

}

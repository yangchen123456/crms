package com.bh.crms.servlet;

import com.bh.crms.pojo.Crms;
import com.bh.crms.service.QueryService;
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
import java.util.List;

@WebServlet(urlPatterns = "/query")
public class QueryServlet extends HttpServlet {
    @Autowired
    private QueryService queryService;
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String cname1 = req.getParameter("cname");
        String gender = req.getParameter("gender");
        String cellphone = req.getParameter("cellphone");
        String email = req.getParameter("email");
        //uuid获取id
        String id = JdbcUtil.getId();
        //构造方法
        if(cname1!=null ){
            Crms crms = new Crms(cname1,gender,cellphone,email);
            List list = queryService.query(crms);
            req.setAttribute("list",list);
            //跳转页面
            req.getRequestDispatcher("list.jsp").forward(req,resp);
        }else {
            req.setAttribute("msg","请输入参数");
            //跳转页面
            req.getRequestDispatcher("msg.jsp").forward(req,resp);
        }

    }
}

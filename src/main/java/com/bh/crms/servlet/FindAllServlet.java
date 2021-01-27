package com.bh.crms.servlet;

import com.bh.crms.service.AddServiceImpl;
import com.bh.crms.service.FindAllService;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns = "/findAll")
public class FindAllServlet extends HttpServlet {
    @Autowired
    private FindAllService findAllService;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //调用查询方法
        List list = findAllService.findAll();
        //添加
        req.setAttribute("list",list);
        //跳转页面
        req.getRequestDispatcher("list.jsp").forward(req,resp);
    }
}

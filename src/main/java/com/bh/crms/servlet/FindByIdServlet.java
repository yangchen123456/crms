package com.bh.crms.servlet;

import com.bh.crms.pojo.Crms;
import com.bh.crms.service.FindAllService;
import com.bh.crms.service.FindByIdService;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/findById")
public class FindByIdServlet extends HttpServlet {
    @Autowired
    private FindByIdService findByIdService;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


        //获取id参数
        String id = req.getParameter("id");
        //执行根据id查询
        Crms crms = findByIdService.findById(id);
        //添加
        req.setAttribute("crms",crms);

        //跳转页面
        req.getRequestDispatcher("edit.jsp").forward(req,resp);
    }
}

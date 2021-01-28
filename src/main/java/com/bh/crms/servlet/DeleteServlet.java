package com.bh.crms.servlet;

import com.bh.crms.service.DeleteService;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/delete")
public class DeleteServlet extends HttpServlet {
    @Autowired
    private DeleteService deleteService;
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //获取删除的id
        String id = req.getParameter("id");
        //调用方法传入id
        int i = deleteService.deleteById(id);

        if(1 == i){
            req.setAttribute("msg","删除成功");
        }else {
            req.setAttribute("msg","删除失败");
        }
        //跳转页面
        req.getRequestDispatcher("msg.jsp").forward(req,resp);

    }
}

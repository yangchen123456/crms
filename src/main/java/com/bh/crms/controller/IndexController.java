package com.bh.crms.controller;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {
    @RequestMapping("/index")
    public String toIndex(){
        return "index";
    }

//    @RequestMapping("/find")
//    public String find(){
//        return "find";
//    }
}
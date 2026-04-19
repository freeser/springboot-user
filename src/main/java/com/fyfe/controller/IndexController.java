package com.fyfe.controller;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexController {

    // addViewControllers 替代了 无返回值的
    @GetMapping("index")
    public String index(Model model) {
        model.addAttribute("uname", "张三");
        return "index";
    }

    @GetMapping("home")
    public String home(HttpServletRequest request){
        request.setAttribute("uname","首页");
        return "index";
    }
}
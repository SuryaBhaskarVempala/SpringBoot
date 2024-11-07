package com.Jsp.DemoJsp.Controller;

import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HomeController {

    @GetMapping("/")
    public String welcomePage() {
        return "index";
    }

    @RequestMapping("/add")
    public String add(@RequestParam("num1") int i, @RequestParam("num2") int j, HttpSession session){
        int num3=i+j;
        session.setAttribute("num3",num3);
        return "result";
    }
}

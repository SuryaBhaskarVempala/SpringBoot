package com.example.Security2.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class ErrorController implements org.springframework.boot.web.servlet.error.ErrorController {

    @RequestMapping("/error")
    @ResponseBody
    public String handleError() {
        return "Something went wrong. Please try again.";
    }

    public String getErrorPath() {
        return "/error";
    }
}

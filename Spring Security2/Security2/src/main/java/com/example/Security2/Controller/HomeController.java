package com.example.Security2.Controller;

import com.example.Security2.Model.Images;
import com.example.Security2.Model.Users;
import com.example.Security2.Service.MyUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@Controller
public class HomeController {

    @Autowired
    private MyUserService service;

    @RequestMapping("/")
    public String home(Model model) {
        List<Images> list = service.getImagesAll();
        model.addAttribute("items", list);
        return "main"; // Ensure this matches the Thymeleaf template name
    }

    @RequestMapping("/login")
    public String login() {
        return "login"; // No need for .html if Thymeleaf is configured properly
    }

    @RequestMapping("/logout-success")
    public String logout() {
        return "login";
    }

    @RequestMapping("/signup")
    public String signup() {
        return "signup";
    }

    @RequestMapping("/images")
    public String getImagesClass(){
        return "imageupload";
    }

    @PostMapping("/register")
    public String register(@ModelAttribute("result") Users users) {
        service.register(users);
        return "redirect:/login";
    }

    @PostMapping("/imageUp")
    public String upload(@RequestParam("name") String name, @RequestParam("image") MultipartFile file) throws IOException {
        service.upload(file, name);
        return "redirect:/"; // Redirect to home after upload
    }
}

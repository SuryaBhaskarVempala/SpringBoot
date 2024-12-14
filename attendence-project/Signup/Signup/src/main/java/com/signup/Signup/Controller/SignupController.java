package com.signup.Signup.Controller;

import com.signup.Signup.Model.Login;
import com.signup.Signup.Model.Signup;
import com.signup.Signup.Service.SignupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
public class SignupController {

    @Autowired
    private SignupService service;

    @PostMapping("/signupMicro")
    public String signup(@RequestBody Signup signup) {
        System.out.println("Received login: " + signup.getPassword()+" : "+signup.getName()+" : "+signup.getEmail()+" : "+signup.getEid()); // Log the received object
        String val = service.signup(signup);
        if (val.equals("success")) {
            System.out.println("sucess-controller");
            return "sucess";
        }
        else if(val.equals("idTaken")) {
            System.out.println("idTaken-controller");
            return "idTaken";
        }
        else if(val.equals("emailTaken")) {
            System.out.println("emailTaken-controller");
            return "emailTaken";
        }
        else {
            System.out.println("error-controller");
            return "error";
        }
    }

    @RequestMapping("/loginMicro")
    public String login(@RequestBody Login login){
        System.out.println("Received login: " + login.getPassword()+" : "+login.getUsername()); // Log the received object
        String val = service.login(login);
        if (val.equals("sucess")) {
            System.out.println("sucess-controller");
            return "sucess";
        }
        else {
            System.out.println("error-controller");
            return "error";
        }
    }
}

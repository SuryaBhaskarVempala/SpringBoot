package com.login.Login.Controller;

import com.login.Login.Model.Login;
import com.login.Login.Model.Signup;
import com.login.Login.Service.LoginService;
import com.netflix.discovery.converters.Auto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
public class LoginController {

    @Autowired
    private LoginService service;

    @PostMapping("/signup")
    public ResponseEntity<String> signup(@RequestBody Signup signup){
        System.out.println(signup.getEid()+" : "+signup.getEmail()+" : "+signup.getPassword()+" : "+signup.getName());
        String val=service.signup(signup);
        if(val.equals("sucess")) {
            System.out.println("Controller-level : sucess");
            return new ResponseEntity<>("{\"msg\":\"sucess\"}", HttpStatus.OK);
        }
        else if(val.equals("idTaken")) {
            System.out.println("idTaken");
            return new ResponseEntity<>("{\"msg\":\"idTaken\"}", HttpStatus.NOT_ACCEPTABLE);
        }
        else if(val.equals("emailTaken")) {
            System.out.println("emailTaken");
            return new ResponseEntity<>("{\"msg\":\"emailTaken\"}", HttpStatus.NOT_ACCEPTABLE);
        }
        else {
            System.out.println("Controller-level : error");
            return new ResponseEntity<>("{\"msg\":\"error\"}", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @RequestMapping("/login")
    public ResponseEntity<String> login(@RequestBody Login login){
        System.out.println("Received login: " + login.getPassword()+" : "+login.getUsername()); // Log the received object
        String val = service.login(login);
        if (val.equals("sucess")) {
            System.out.println("Controller-level : sucess");
            return new ResponseEntity<>("{\"msg\":\"sucess\"}", HttpStatus.OK);
        }
        else {
            return new ResponseEntity<>("{\"msg\":\"error\"}", HttpStatus.BAD_REQUEST);
        }
    }
}

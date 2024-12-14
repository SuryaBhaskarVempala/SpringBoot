package com.login.Login.Service;

import com.login.Login.Feign.SignUp;
import com.login.Login.Model.Login;
import com.login.Login.Model.Signup;
import com.login.Login.Repository.LoginRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class LoginService {

    @Autowired
    private SignUp feign;

    @Autowired
    private LoginRepo repo;

    public String login(Login login) {
        String value=feign.login(login);
        System.out.print("service-level");
        System.out.print(value);
        if(value.equals("sucess")) {
            repo.save(login);
        }
        return value;
    }

    public String signup(Signup signup) {
        String value=feign.signup(signup);
        System.out.print("service-level");
        System.out.print(value);
        return value;
    }
}

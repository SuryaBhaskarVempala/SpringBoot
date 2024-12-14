package com.login.Login.Feign;

import com.login.Login.Model.Login;
import com.login.Login.Model.Signup;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient("SIGNUP-SERVICE")
public interface SignUp {

    @PostMapping("/signupMicro")
    public String signup(@RequestBody Signup signup);

    @RequestMapping("/loginMicro")
    public String login(@RequestBody Login login);
}

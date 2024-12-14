package com.signup.Signup.Bcrypt;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class Bcrypt_Convertor {

    private static final BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder(12);

    // Method to encrypt password
    public  String encryptPassword(String rawPassword) {
        return passwordEncoder.encode(rawPassword);
    }

    // Method to verify password
    public  boolean verifyPassword(String rawPassword, String encodedPassword) {
        return passwordEncoder.matches(rawPassword, encodedPassword);
    }
}

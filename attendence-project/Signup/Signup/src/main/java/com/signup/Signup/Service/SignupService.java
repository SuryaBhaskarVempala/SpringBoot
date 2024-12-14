package com.signup.Signup.Service;

import com.signup.Signup.Bcrypt.Bcrypt_Convertor;
import com.signup.Signup.Model.Login;
import com.signup.Signup.Model.Signup;
import com.signup.Signup.Repository.SignupRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SignupService {
    @Autowired
    private SignupRepo repo;

    @Autowired
    private Bcrypt_Convertor convertor;

    public String signup(Signup signup_obj) {
        Signup emailValidation = repo.findByEmail(signup_obj.getEmail());

        if (emailValidation != null) {
            System.out.println("Email taken: " + emailValidation.getEmail());
            return "emailTaken";
        }

        Signup idValidation = repo.findByEid(signup_obj.getEid());

        if (idValidation != null) {
            System.out.println("ID taken: " + idValidation.getEid());
            return "idTaken";
        }
        else{
        String pass = convertor.encryptPassword(signup_obj.getPassword());
        signup_obj.setPassword(pass);
        repo.save(signup_obj);
        System.out.println("Success - password encrypted and saved");
        return "success";
        }
    }

        public String login(Login login) {
           Signup eid_login=repo.findByEid(login.getUsername());
           System.out.println(eid_login.getPassword());
           if(eid_login == null){
               System.out.println("error");
               return "error";
           }
           else {
               if(convertor.verifyPassword(login.getPassword(),eid_login.getPassword())){
                   System.out.println("sucess");
                   return "sucess";
               }
               System.out.println("error:2");
               return "error";
           }
        }
}

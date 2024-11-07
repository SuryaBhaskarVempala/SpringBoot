package com.example.Security.Service;

import com.example.Security.Config.UserPrincipal;
import com.example.Security.Model.User;
import com.example.Security.Repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class MyUserDetailsService implements UserDetailsService {

    @Autowired
    private UserRepo repo;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User users = repo.findByUsername(username);
        if(users==null)
                throw  new UsernameNotFoundException("error 404");
        return new UserPrincipal(users);
    }
}

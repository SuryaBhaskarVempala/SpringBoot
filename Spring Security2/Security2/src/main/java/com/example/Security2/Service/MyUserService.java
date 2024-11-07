package com.example.Security2.Service;

import com.example.Security2.Config.UsersPricipal;
import com.example.Security2.Model.Images;
import com.example.Security2.Model.Users;
import com.example.Security2.Repository.ImageRepo;
import com.example.Security2.Repository.UsersRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@Service
public class MyUserService implements UserDetailsService {

    @Autowired
    private UsersRepo repo;

    @Autowired
    private ImageRepo imageRepo;

    BCryptPasswordEncoder encoder=new BCryptPasswordEncoder(12);

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Users users = repo.findByUsername(username);
        if (users == null)
            throw new UsernameNotFoundException("User not found, redirecting to signup");
        return new UsersPricipal(users);
    }

    public void register(Users users) {
        users.setPassword(encoder.encode(users.getPassword()));
        repo.save(users);
    }

    public void upload(MultipartFile file, String name) throws IOException {
        Images images = new Images();
        images.setName(name);
        images.setImage(file.getBytes());
        imageRepo.save(images);
    }

        public List<Images> getImagesAll() {
        return imageRepo.findAll();
    }

}

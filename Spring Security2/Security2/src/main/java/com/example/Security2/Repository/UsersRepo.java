package com.example.Security2.Repository;

import com.example.Security2.Model.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsersRepo extends JpaRepository<Users,Integer> {
    Users findByUsername(String username);
}

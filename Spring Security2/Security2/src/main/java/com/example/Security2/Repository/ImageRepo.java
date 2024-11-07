package com.example.Security2.Repository;

import com.example.Security2.Model.Images;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ImageRepo extends JpaRepository<Images,Integer> {
}

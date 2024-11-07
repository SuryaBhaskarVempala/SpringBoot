package com.Restfull.Rest.Repository;

import com.Restfull.Rest.Model.Alien;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface AlienRepo extends JpaRepository<Alien,Integer> {
    Alien findAlienByName(String name);
    Alien deleteById(int id);
}

package com.BootMVC.Mvc.Repository;

import com.BootMVC.Mvc.MOdel.Alien;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface AlienRepo extends JpaRepository<Alien, Integer> {
    Alien findAlienByName(String name);

    @Modifying
    @Transactional
    @Query("DELETE FROM Alien a WHERE a.name = :name")
    void deleteAlienByName(@Param("name") String name);
}

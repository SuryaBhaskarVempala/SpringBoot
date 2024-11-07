package com.Restfull.Rest.Controller;

import com.Restfull.Rest.Model.Alien;
import com.Restfull.Rest.Repository.AlienRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class HomeController {

    @Autowired
    private AlienRepo repo;

    @GetMapping("/getAliens")
    public List<Alien> getAliens(){
        List<Alien> list = repo.findAll();
        return list;
    }

    @PostMapping("/addAlien")
    public Alien addAlien(@RequestBody Alien alien){
        Alien a=repo.save(alien);
        return a;
    }

    @GetMapping("/getAlienByName/{name}")
    public Alien getAliens(@PathVariable("name") String name){
        Alien alien = repo.findAlienByName(name);
        return alien;
    }

     @GetMapping("/getAlienById/{id}")
    public Alien getAliens(@PathVariable("id") int id){
        return repo.findById(id).orElse(null);
    }

    @DeleteMapping("/deleteAlienById/{id}")
    public Alien deleteAlien(@PathVariable("id") int id){
        Alien alien = repo.deleteById(id);
        return alien;
    }

   @PutMapping("/update")
   public Alien updateAlien(@RequestBody Alien alien){
       Alien a=repo.save(alien);
       return a;
   }
}

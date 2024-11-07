package com.BootMVC.Mvc.Controller;

import com.BootMVC.Mvc.MOdel.Alien;
import com.BootMVC.Mvc.Repository.AlienRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class HomeController {

    @Autowired
    private AlienRepo repo;
    @RequestMapping("/")
    public String welcome(){
        return "index";
    }

    @PostMapping("/addAlien")
    public String addAlien(@ModelAttribute("result") Alien alien){
        repo.save(alien);
        return "result";
    }

    @GetMapping("/getAliens")
    public String getAliens(Model m){
        List<Alien> list=repo.findAll();
        m.addAttribute("result",list);
        return "result";
    }

    @GetMapping("/getAlien")
    public String getAlien(@RequestParam("id") int id, Model m){
        Alien alien=repo.findById(id).orElse(new Alien());
        m.addAttribute("result",alien);
        return "result";
    }

    @GetMapping("/getAlienByName")
    public String getAlienByName(@RequestParam("name") String name, Model m){
        Alien alien=repo.findAlienByName(name);
        m.addAttribute("result",alien);
        return "result";
    }

    @GetMapping("/deleteByName")
    public String deleteAlienByName(@RequestParam("name") String name){
        repo.deleteAlienByName(name);
        return "index";
    }

    @RequestMapping("/deleteAlien")
    public String deleteAlien(@RequestParam("id") int id, Model m){
        repo.deleteById(id);
        return "index";
    }
}

package com.BootMVC.Mvc.MOdel;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.stereotype.Component;

@NoArgsConstructor
@Data
@ToString
@Entity
@Component
public class Alien {
    @Id
    private int id;
    private String name;
}

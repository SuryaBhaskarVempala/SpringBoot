package com.Restfull.Rest.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.stereotype.Component;

@Data
@NoArgsConstructor
@ToString
@Entity
@Component
public class Alien {
    @Id
    private int id;
    private String name;
}

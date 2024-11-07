package com.example.Security2.Model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Base64;

@Data
@NoArgsConstructor
@Entity
@Component
public class Images {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    @Lob
    private byte[] image;

    // Getters and setters

    public String getBase64Image() {
        return Base64.getEncoder().encodeToString(this.image);
    }
}

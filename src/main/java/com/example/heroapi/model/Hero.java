package com.example.heroapi.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Hero {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String universe;

    private int strength;
    private int defense;
    private int speed;
    private int accuracy;
    private int intelligence;
    private int luck;
}

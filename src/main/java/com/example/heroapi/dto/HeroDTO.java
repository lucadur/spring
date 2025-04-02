package com.example.heroapi.dto;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class HeroDTO {
    private String name;
    private String universe;

    private int strength;
    private int defense;
    private int speed;
    private int accuracy;
    private int intelligence;
    private int luck;
}

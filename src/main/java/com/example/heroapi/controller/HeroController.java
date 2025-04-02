package com.example.heroapi.controller;

import com.example.heroapi.dto.HeroDTO;
import com.example.heroapi.service.HeroService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/heroes")
@RequiredArgsConstructor
public class HeroController {

    private final HeroService heroService;

    @GetMapping
    public List<HeroDTO> getAllHeroes() {
        return heroService.getAllHeroes();
    }

    @PostMapping
    public HeroDTO addHero(@RequestBody HeroDTO heroDTO) {
        return heroService.saveHero(heroDTO);
    }

    @GetMapping("/random")
    public ResponseEntity<HeroDTO> getRandomHero() {
        HeroDTO hero = heroService.getRandomHero();
        return hero != null ? ResponseEntity.ok(hero) : ResponseEntity.noContent().build();
    }
}

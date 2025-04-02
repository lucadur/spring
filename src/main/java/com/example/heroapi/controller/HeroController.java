package com.example.heroapi.controller;

import com.example.heroapi.model.Hero;
import com.example.heroapi.service.HeroService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/heroes")
public class HeroController {

    private final HeroService heroService;

    public HeroController(HeroService heroService) {
        this.heroService = heroService;
    }

    @GetMapping
    public List<Hero> getAllHeroes() {
        return heroService.getAllHeroes();
    }

    @PostMapping
    public Hero addHero(@RequestBody Hero hero) {
        return heroService.saveHero(hero);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Hero> getHeroById(@PathVariable Long id) {
        return heroService.getHeroById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/random")
    public ResponseEntity<Hero> getRandomHero() {
        Hero hero = heroService.getRandomHero();
        if (hero == null) return ResponseEntity.noContent().build();
        return ResponseEntity.ok(hero);
    }

    @GetMapping("/search")
    public List<Hero> searchByName(@RequestParam String name) {
        return heroService.searchByName(name);
    }
}

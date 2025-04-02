// src/main/java/com/example/heroapi/service/HeroService.java
package com.example.heroapi.service;

import com.example.heroapi.model.Hero;
import com.example.heroapi.repository.HeroRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Random;

@Service
public class HeroService {

    private final HeroRepository heroRepository;
    private final Random random = new Random();

    public HeroService(HeroRepository heroRepository) {
        this.heroRepository = heroRepository;
    }

    public List<Hero> getAllHeroes() {
        return heroRepository.findAll();
    }

    public Hero saveHero(Hero hero) {
        return heroRepository.save(hero);
    }

    public Optional<Hero> getHeroById(Long id) {
        return heroRepository.findById(id);
    }

    public Hero getRandomHero() {
        List<Hero> allHeroes = heroRepository.findAll();
        if (allHeroes.isEmpty()) return null;
        return allHeroes.get(random.nextInt(allHeroes.size()));
    }

    public List<Hero> searchByName(String name) {
        return heroRepository.findByNameContainingIgnoreCase(name);
    }
}

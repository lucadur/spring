package com.example.heroapi.service;

import com.example.heroapi.dto.HeroDTO;
import com.example.heroapi.mapper.HeroMapper;
import com.example.heroapi.model.Hero;
import com.example.heroapi.repository.HeroRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;

@Service
@RequiredArgsConstructor
@Slf4j
public class HeroService {

    private final HeroRepository heroRepository;
    private final HeroMapper heroMapper;
    private final Random random = new Random();

    public List<HeroDTO> getAllHeroes() {
        log.info("Récupération de tous les héros");
        return heroMapper.toDtoList(heroRepository.findAll());
    }

    public HeroDTO saveHero(HeroDTO heroDTO) {
        Hero hero = heroMapper.toEntity(heroDTO);
        validateHeroStats(hero);
        log.info("Héros sauvegardé : {}", hero.getName());
        return heroMapper.toDto(heroRepository.save(hero));
    }

    public HeroDTO getRandomHero() {
        List<Hero> all = heroRepository.findAll();
        if (all.isEmpty()) return null;
        return heroMapper.toDto(all.get(random.nextInt(all.size())));
    }

    private void validateHeroStats(Hero hero) {
        int total = hero.getStrength() + hero.getDefense() + hero.getSpeed() +
                hero.getAccuracy() + hero.getIntelligence() + hero.getLuck();
        if (total > 300) {
            throw new IllegalArgumentException("Le total des stats d’un héros ne doit pas dépasser 300.");
        }
    }
}

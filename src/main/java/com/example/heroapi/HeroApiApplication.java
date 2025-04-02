package com.example.heroapi;

import com.example.heroapi.service.ArenaRegistrationService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class HeroApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(HeroApiApplication.class, args);
    }

    @Bean
    CommandLineRunner register(ArenaRegistrationService arenaRegistrationService) {
        return args -> arenaRegistrationService.registerToArena();
    }
}

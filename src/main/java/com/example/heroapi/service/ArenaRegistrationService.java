package com.example.heroapi.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

@Service
@Slf4j
public class ArenaRegistrationService {

    private final RestTemplate restTemplate = new RestTemplate();

    public void registerToArena() {
        String arenaUrl ="http://51.210.251.137/arena/register";


        Map<String, String> requestBody = new HashMap<>();
        requestBody.put("studentName", "Lucas");
        requestBody.put("baseUrl", "http://localhost:8080");

        log.info("Tentative d'enregistrement à l'arène : {}", requestBody);

        try {
            restTemplate.postForObject(arenaUrl, requestBody, String.class);
            log.info("Enregistrement à l’arène réussi !");
        } catch (Exception e) {
            log.error("Échec de l’enregistrement à l’arène : {}", e.getMessage());
        }
    }

}

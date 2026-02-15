package com.example.rag.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

@Slf4j
@Service
public class OllamaService {

    @Value("${ollama.url}")
    private String ollamaUrl;

    @Value("${ollama.model}")
    private String model;

    private final RestTemplate restTemplate = new RestTemplate();

    @Cacheable(value = "response", key ="#question")
    public String askQuestion(String context, String question) {

        log.info("==== inside askQuestion ==== ");

        String prompt = """
        Answer the question using ONLY the information below.
        If the answer is not present, say "I don't know".

        Context:
        
        %s

        Question:
        %s
        """.formatted(context, question);

        Map<String, Object> body = new HashMap<>();
        body.put("model", model);
        body.put("prompt", prompt);
        body.put("stream", false);

        ResponseEntity<Map> response =
                restTemplate.postForEntity(ollamaUrl, body, Map.class);

        return response.getBody().get("response").toString();
    }
}

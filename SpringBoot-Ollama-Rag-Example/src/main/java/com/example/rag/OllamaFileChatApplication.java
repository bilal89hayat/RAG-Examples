package com.example.rag;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class OllamaFileChatApplication {

    public static void main(String[] args) {
        SpringApplication.run(OllamaFileChatApplication.class, args);
        System.out.println("✅ Ollama File Chat App is running on http://localhost:8080");
    }
}

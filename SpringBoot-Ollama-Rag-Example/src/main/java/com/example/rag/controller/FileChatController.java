package com.example.rag.controller;

import com.example.rag.service.FileReadingService;
import com.example.rag.service.OllamaService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/chat")
public class FileChatController {

    private final FileReadingService fileReaderService;
    private final OllamaService ollamaService;

    public FileChatController(FileReadingService fileReaderService,
                              OllamaService ollamaService) {
        this.fileReaderService = fileReaderService;
        this.ollamaService = ollamaService;
    }

    @PostMapping("/ask")
    public String ask(
            @RequestParam("file") MultipartFile file,
            @RequestParam("question") String question
    ) throws Exception {

        String fileContent = fileReaderService.readFile(file);
        return ollamaService.askQuestion(fileContent, question);
    }
}

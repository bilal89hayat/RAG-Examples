package com.example.rag.service;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class FileReadingService {

    public String readFile(MultipartFile file) throws Exception {
        String filename = file.getOriginalFilename();

        if (filename.endsWith(".txt")) {
            return new String(file.getBytes());
        }

        if (filename.endsWith(".pdf")) {
            PDDocument document = PDDocument.load(file.getInputStream());
            PDFTextStripper stripper = new PDFTextStripper();
            String text = stripper.getText(document);
            document.close();
            return text;
        }

        throw new RuntimeException("Unsupported file type");
    }
}

package com.loveletters.app.service;

import com.loveletters.app.dto.LetterForm;
import com.loveletters.app.model.Letter;
import com.loveletters.app.repository.LetterRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.security.SecureRandom;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class LetterService {
    
    private final LetterRepository letterRepository;
    private static final String SLUG_CHARACTERS = "abcdefghijklmnopqrstuvwxyz0123456789";
    private static final int SLUG_LENGTH = 7;
    private static final SecureRandom random = new SecureRandom();
    
    @Transactional
    public Letter createLetter(LetterForm form) {
        log.debug("Creating new letter with title: {}", form.getTitle());
        
        String slug = generateUniqueSlug();
        
        Letter letter = Letter.builder()
                .title(form.getTitle())
                .recipientName(form.getRecipientName())
                .content(form.getContent())
                .signature(form.getSignature())
                .templateKey(form.getTemplateKey())
                .slug(slug)
                .isPublic(true)
                .build();
        
        Letter savedLetter = letterRepository.save(letter);
        log.info("Letter created successfully with slug: {}", slug);
        
        return savedLetter;
    }
    
    public Optional<Letter> getLetterBySlug(String slug) {
        log.debug("Fetching letter by slug: {}", slug);
        return letterRepository.findBySlug(slug);
    }
    
    private String generateUniqueSlug() {
        String slug;
        int attempts = 0;
        int maxAttempts = 10;
        
        do {
            slug = generateSlug();
            attempts++;
            
            if (attempts >= maxAttempts) {
                log.warn("Max attempts reached for slug generation, increasing length");
                slug = generateSlug() + generateSlug().substring(0, 2);
            }
            
        } while (letterRepository.existsBySlug(slug));
        
        return slug;
    }
    
    private String generateSlug() {
        StringBuilder slug = new StringBuilder(SLUG_LENGTH);
        
        for (int i = 0; i < SLUG_LENGTH; i++) {
            int index = random.nextInt(SLUG_CHARACTERS.length());
            slug.append(SLUG_CHARACTERS.charAt(index));
        }
        
        return slug.toString();
    }
}

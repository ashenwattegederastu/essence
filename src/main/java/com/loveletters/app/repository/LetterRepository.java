package com.loveletters.app.repository;

import com.loveletters.app.model.Letter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface LetterRepository extends JpaRepository<Letter, Long> {
    
    Optional<Letter> findBySlug(String slug);
    
    boolean existsBySlug(String slug);
}

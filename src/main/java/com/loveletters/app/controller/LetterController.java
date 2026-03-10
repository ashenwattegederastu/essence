package com.loveletters.app.controller;

import com.loveletters.app.dto.LetterForm;
import com.loveletters.app.model.Letter;
import com.loveletters.app.service.LetterService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequiredArgsConstructor
@Slf4j
public class LetterController {
    
    private final LetterService letterService;
    
    @GetMapping("/")
    public String home() {
        log.debug("Rendering home page");
        return "index";
    }

    @GetMapping("/templates")
    public String templateGallery() {
        log.debug("Rendering template gallery page");
        return "template-gallery";
    }
    
    @GetMapping("/create")
    public String showCreateForm(@RequestParam(required = false) String template, Model model) {
        log.debug("Rendering create letter form");

        LetterForm letterForm = new LetterForm();
        if (template != null && !template.isBlank()) {
            letterForm.setTemplateKey(template);
        }

        model.addAttribute("letterForm", letterForm);
        return "create-letter";
    }
    
    @PostMapping("/create")
    public String createLetter(@Valid @ModelAttribute("letterForm") LetterForm letterForm,
                              BindingResult bindingResult,
                              RedirectAttributes redirectAttributes) {
        
        if (bindingResult.hasErrors()) {
            log.warn("Validation errors in letter form: {}", bindingResult.getAllErrors());
            return "create-letter";
        }
        
        try {
            Letter savedLetter = letterService.createLetter(letterForm);
            log.info("Letter created successfully with slug: {}", savedLetter.getSlug());
            
            return "redirect:/letter/" + savedLetter.getSlug() + "/share";
            
        } catch (Exception e) {
            log.error("Error creating letter", e);
            redirectAttributes.addFlashAttribute("error", "An error occurred while creating your letter. Please try again.");
            return "redirect:/create";
        }
    }
    
    @GetMapping("/letter/{slug}")
    public String viewLetter(@PathVariable String slug, Model model) {
        log.debug("Viewing letter with slug: {}", slug);
        
        return letterService.getLetterBySlug(slug)
                .map(letter -> {
                    model.addAttribute("letter", letter);
                    return "view-letter";
                })
                .orElseGet(() -> {
                    log.warn("Letter not found with slug: {}", slug);
                    return "redirect:/";
                });
    }

    @GetMapping("/letter/{slug}/share")
    public String shareLetter(@PathVariable String slug, Model model) {
        log.debug("Rendering share success page for slug: {}", slug);

        return letterService.getLetterBySlug(slug)
                .map(letter -> {
                    model.addAttribute("letter", letter);
                    return "share-success";
                })
                .orElseGet(() -> {
                    log.warn("Letter not found for share page with slug: {}", slug);
                    return "redirect:/";
                });
    }
}

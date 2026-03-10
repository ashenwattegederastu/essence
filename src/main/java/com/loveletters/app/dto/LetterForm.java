package com.loveletters.app.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class LetterForm {
    
    @NotBlank(message = "Title is required")
    @Size(max = 200, message = "Title must be less than 200 characters")
    private String title;
    
    @NotBlank(message = "Recipient name is required")
    @Size(max = 100, message = "Recipient name must be less than 100 characters")
    private String recipientName;
    
    @NotBlank(message = "Letter content is required")
    @Size(min = 10, message = "Letter must be at least 10 characters")
    private String content;
    
    @NotBlank(message = "Signature is required")
    @Size(max = 100, message = "Signature must be less than 100 characters")
    private String signature;
    
    @NotBlank(message = "Template selection is required")
    private String templateKey;
}

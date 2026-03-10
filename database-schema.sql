-- Essence Love Letters Database Schema
-- This file is for reference only - Spring Boot will create tables automatically

-- Create letters table
CREATE TABLE IF NOT EXISTS letters (
    id BIGSERIAL PRIMARY KEY,
    title VARCHAR(255) NOT NULL,
    recipient_name VARCHAR(255) NOT NULL,
    content TEXT NOT NULL,
    signature VARCHAR(255) NOT NULL,
    template_key VARCHAR(50) NOT NULL,
    slug VARCHAR(50) NOT NULL UNIQUE,
    is_public BOOLEAN NOT NULL DEFAULT true,
    created_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP
);

-- Create index on slug for faster lookups
CREATE INDEX IF NOT EXISTS idx_letters_slug ON letters(slug);

-- Create index on created_at for potential future features
CREATE INDEX IF NOT EXISTS idx_letters_created_at ON letters(created_at DESC);

-- Sample query to view all letters
-- SELECT id, title, recipient_name, slug, template_key, created_at FROM letters ORDER BY created_at DESC;

-- Sample query to find a letter by slug
-- SELECT * FROM letters WHERE slug = 'abc123x';

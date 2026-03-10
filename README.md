<div align="center">

# ✨ Essence

*Where words become timeless moments*

**A modern love letters platform for the digital age**

[Features](#features) • [Design Philosophy](#design-philosophy) • [Templates](#templates) • [Tech Stack](#tech-stack) • [Getting Started](QUICKSTART.md)

</div>

---

## 💌 About

**Essence** is a web platform that brings back the art of letter writing for the modern age. In a world of fleeting messages and disappearing stories, Essence creates permanent, beautiful spaces for your most heartfelt words.

Write a love letter, share a unique link, and let your words live forever—elegantly designed, privately shared, and always accessible.

### The Vision

- **Timeless**: Letters that don't disappear, don't expire, and stay beautiful forever
- **Intimate**: Personal messages meant for one person, accessed through a unique, private link
- **Beautiful**: Three carefully crafted visual themes that make words feel special
- **Simple**: No accounts, no login walls—just write, save, and share

---

## ✨ Features

### 🖋️ **Elegant Letter Creation**
Write your thoughts in a distraction-free editor with real-time preview. Choose from three beautiful templates that make every word feel special.

### 🎨 **Visual Templates**
- **Classic** — Timeless elegance with clean serif typography and neutral tones
- **Rose** — Romantic warmth with soft pink accents and delicate styling  
- **Midnight** — Deep intimacy with a dark theme and golden highlights

### 🔗 **Instant Sharing**
Every letter gets a unique, permanent link. Share it once, and it works forever—no downloads, no passwords (yet), no friction.

### 💾 **Persistent Storage**
Letters are safely stored in a PostgreSQL database, ensuring they remain accessible for years to come.

### 🌐 **Zero Friction Access**
No sign-ups, no logins, no barriers. Just write and share. Perfect for spontaneous expressions of love.

---

## 🎯 Design Philosophy

Essence was built with a few core principles:

1. **Content First** — The letter is the hero. Every design decision prioritizes readability and emotional impact.

2. **Simplicity** — The MVP intentionally avoids complexity. No user accounts, no settings to configure, no decisions to make beyond choosing a template.

3. **Privacy by Architecture** — Letters are accessible only through their unique, unguessable URLs. The system doesn't track who views what.

4. **Timeless Technology** — Built on stable, proven technologies (Spring Boot, PostgreSQL, Thymeleaf) that will stand the test of time.

---

## 🎨 Templates

Each template is carefully designed to evoke a different mood:

| Template | Mood | Typography | Color Palette |
|----------|------|------------|---------------|
| **Classic** | Elegant & Traditional | Serif, formal spacing | Cream, charcoal, gold accents |
| **Rose** | Romantic & Warm | Soft serif, flowing | Blush pink, deep rose, ivory |
| **Midnight** | Intimate & Modern | Clean serif, bold | Deep navy, gold, pure white |

All templates are fully responsive and optimized for mobile reading.

---

## 🛠️ Tech Stack

<div align="center">

| Layer | Technology |
|-------|-----------|
| **Backend** | Spring Boot 3.2.3 |
| **Language** | Java 21 |
| **Web Framework** | Spring MVC + Thymeleaf |
| **Database** | PostgreSQL (Supabase compatible) |
| **Frontend** | HTML5, CSS3, Vanilla JavaScript |
| **Build Tool** | Maven 3.6+ |
| **Architecture** | MVC with Service Layer |

</div>

**Why These Choices?**

- **Spring Boot**: Battle-tested, production-ready framework with excellent ecosystem
- **Java 21**: Modern language features with long-term support and stability
- **PostgreSQL**: Robust, relational storage perfect for structured letter data
- **Server-Side Rendering**: Fast initial loads, excellent SEO, simpler architecture
- **No Frontend Framework**: Keeps the codebase lean and maintainable

---

## 📂 Project Structure

```
essence/
├── src/main/java/com/loveletters/app/
│   ├── controller/       # HTTP request handlers
│   ├── service/          # Business logic & letter management
│   ├── repository/       # Database access layer
│   ├── model/            # JPA entities
│   ├── dto/              # Data transfer objects
│   └── config/           # Application configuration
├── src/main/resources/
│   ├── templates/        # Thymeleaf HTML templates
│   ├── static/css/       # Stylesheets for each theme
│   └── application.properties
└── frontend_design/      # Original design prototypes
```

**Clean MVC Architecture**: Each layer has a single responsibility, making the codebase easy to understand and extend.

---

## 🚀 Getting Started

Ready to run Essence locally? Check out the [**QUICKSTART.md**](QUICKSTART.md) guide for setup instructions.

For deeper architectural details, see [**ARCHITECTURE.md**](ARCHITECTURE.md).

---

## 🌱 Roadmap & Future Enhancements

The current version is a beautiful MVP. Future possibilities include:

- 👤 **User Accounts** — Save multiple letters, manage your creations
- 🔒 **Password Protection** — Optional password gates for extra privacy
- 🎨 **Custom Themes** — Build your own color schemes and typography
- 🖼️ **Image Support** — Add photos alongside your words
- 📧 **Email Notifications** — Alert recipients when they receive a letter
- 🌍 **Internationalization** — Support for multiple languages
- 📱 **Progressive Web App** — Install as a native-like mobile experience

---

## 📜 License

This project is open source and available for personal and educational use.

---

<div align="center">

**Made with 💜 for everyone who still believes in the power of words**

*Write something beautiful today*

</div>
- 🎨 Expanded template gallery
- 📝 Draft letter saving
- ✉️ Envelope opening animations
- ⏰ Scheduled letter delivery

## Development

### Building for Production

```bash
mvn clean package
```

The JAR file will be created in `target/essence-0.0.1-SNAPSHOT.jar`

### Running the JAR

```bash
java -jar target/essence-0.0.1-SNAPSHOT.jar
```

## Environment Variables

| Variable | Description | Default |
|----------|-------------|---------|
| `DATABASE_URL` | PostgreSQL JDBC URL | `jdbc:postgresql://localhost:5432/essence` |
| `DATABASE_USERNAME` | Database username | `postgres` |
| `DATABASE_PASSWORD` | Database password | `password` |
| `SERVER_PORT` | Application port | `8080` |

## License

MIT License - Feel free to use this project as you wish.

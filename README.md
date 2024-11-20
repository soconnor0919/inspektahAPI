# InspektahAPI - Walmart Product Search Application

A Java-based desktop application that connects to the Walmart API, allowing users to search and sort products through an intuitive graphical interface.

## Features

- Real-time product search through Walmart's API
- Customizable sorting options (price, rating, bestseller)
- Responsive GUI with product cards displaying images and details
- Star rating visualization system
- Adjustable search result quantities

## Tech Stack

- [Java](https://www.java.com/) - Core programming language
- [JavaFX](https://openjfx.io/) - GUI framework (Version 22-ea+16)
- [Gradle](https://gradle.org/) - Build automation tool
- [JUnit](https://junit.org/) - Testing framework
- [OkHttp](https://square.github.io/okhttp/) - HTTP client
- [JSON](https://www.json.org/) - Data interchange format

## Getting Started

1. Clone the repository:
   ```bash
   git clone https://github.com/team02/walmart-search.git
   ```

2. Ensure you have Java 17+ installed

3. Set up API keys:
   - Create directory: `src/main/resources/WalmartAPI/keys/`
   - Create two files in this directory:
     - `private-key.pem`: Your Walmart API private key
     - `consumer-id`: Your Walmart API consumer ID
   These files are gitignored for security. Contact project maintainers for development keys.

4. Build the project:
   ```bash
   ./gradlew build
   ```

5. Run the application:
   ```bash
   ./gradlew run
   ```

## Project Structure

```
src/
├── main/
│   ├── java/WalmartAPI/
│   │   ├── gui/          # GUI components
│   │   ├── logic/        # Business logic and API handling
│   │   └── model/        # Data models
│   └── resources/        # Assets and configuration files
└── test/                 # Test files
```

## Dependencies

- JavaFX: Version 22-ea+16 - [Download](https://mvnrepository.com/artifact/org.openjfx/javafx)
- Apache Commons Codec: Version 1.16.0 - [Download](https://mvnrepository.com/artifact/commons-codec/commons-codec)
- JSON: Version 20231013 - [Download](https://mvnrepository.com/artifact/org.json/json)
- JUnit Jupiter API: Version 5.9.1 - [Download](https://mvnrepository.com/artifact/org.junit.jupiter/junit-jupiter-api)
- OkHttp3: Version 4.12.0 - [Download](https://mvnrepository.com/artifact/com.squareup.okhttp3/okhttp)

## Team

- Sean O'Connor - Scrum Master
- Alec Sanders - Project Owner
- Geoffrey Gaines - Team Member
- Aidan Finkler - Team Member

## Development Timeline

- Sprint 1 (11/2 - 11/9): Initial console-based product search implementation
- Sprint 2 (11/9 - 11/16): Core functionality and R&D
- Sprint 3 (11/16 - 11/27): GUI development and integration
- Sprint 4 (11/27 - 12/4): Final deliverables and documentation

## License

This project is part of CSCI 205 - Software Engineering and Design, Fall 2023, under Prof. Brian King.
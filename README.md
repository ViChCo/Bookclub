# Book Club

Assignment 1 – Spring Boot (Controller, View, Model)

A small book club website built with Java 21, Spring Boot, Spring MVC and Thymeleaf.

## How to run

Requires Java 21. Maven is not needed, the project uses the Maven Wrapper.

Mac/Linux/WSL:

```bash
./run.sh
```

Windows:

```bat
run.bat
```

The app starts at http://localhost:8080

## What to click

| URL | What you should see |
|-----|---------------------|
| http://localhost:8080/home | Greeting and today's date, with links to the other pages |
| http://localhost:8080/books | Table of recommended books (title, author, genre) |
| http://localhost:8080/genre | All books, plus a form to filter by genre |
| http://localhost:8080/genre?type=Fantasy | Only Fantasy books |
| http://localhost:8080/genre?type=Deckare | Only Deckare (crime) books |
| http://localhost:8080/genre?type=Romantik | A message saying no books were found |

On the `/genre` page you can also use the dropdown and the "Visa" button instead of typing the URL.

## Project structure

```
src/main/java/com/example/bokklubb/
├── controller/BookController.java   (3 endpoints: /home, /books, /genre)
├── domain/Book.java                 (model: title, author, genre)
└── BokklubbApplication.java

src/main/resources/templates/
├── home.html
├── booklist.html
└── genre.html
```
package se.yrgo.Bookclub.controller;
import se.yrgo.Bookclub.domain.Book;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDate;
import java.util.List;

    @Controller
    public class BookController {

        private List<Book> getBooks() {
            return List.of(
                    new Book("Sagan om ringen", "J.R.R. Tolkien", "Fantasy"),
                    new Book("Harry Potter och De Vises Sten", "J.K. Rowling", "Fantasy"),
                    new Book("Män som hatar kvinnor", "Stieg Larsson", "Deckare"),
                    new Book("Mannen som inte kunde le", "Henning Mankell", "Deckare"),
                    new Book("Dune", "Frank Herbert", "Science Fiction")
            );
        }

        @GetMapping("/home")
        public String home(Model model) {
            model.addAttribute("greeting", "Välkommen till Bokklubben!");
            model.addAttribute("date", LocalDate.now());
            return "home";
        }

        @GetMapping("/books")
        public String books(Model model) {
            model.addAttribute("books", getBooks());
            return "booklist";
        }

        @GetMapping("/genre")
        public String genre(@RequestParam(name = "type", required = false) String type, Model model) {
            List<Book> all = getBooks();
            List<Book> result;

            if (type == null || type.isBlank()) {
                result = all;
            } else {
                result = all.stream()
                        .filter(b -> b.getGenre().equalsIgnoreCase(type))
                        .toList();
            }

            model.addAttribute("books", result);
            model.addAttribute("selectedGenre", type == null ? "" : type);
            model.addAttribute("genres", List.of("Fantasy", "Deckare", "Science Fiction"));
            return "genre";
        }
    }


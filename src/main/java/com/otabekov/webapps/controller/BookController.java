package com.otabekov.webapps.controller;

import com.otabekov.webapps.model.BookStore;
import com.otabekov.webapps.reposistory.BookReposistory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.awt.print.Book;
import java.time.LocalDate;
import java.util.List;

@Controller
public class BookController {

    @Autowired
    private BookReposistory bookRepository;
    @Autowired
    private BookReposistory bookReposistory;

    @GetMapping("/")
    public String book(Model store) {
        List<BookStore> books = bookRepository.findAll();
        store.addAttribute("books",books);
        return "book";
    }

    @GetMapping("/book-form")
    public String bookForm() {
        return "book-form";
    }

    @PostMapping("/book-form")
    public String addBook(@RequestParam("title") String title,
                          @RequestParam("author") String author,
                          @RequestParam("genre") String genre,
                          @RequestParam("price") double price,
                          @RequestParam("publishDate") String publishDate) {

        BookStore bookStore = new BookStore();
        bookStore.setTitle(title);
        bookStore.setAuthor(author);
        bookStore.setGenre(genre);
        bookStore.setPrice(price);
        bookStore.setDot(LocalDate.parse(publishDate));  // Convert String to LocalDate

        bookRepository.save(bookStore);
        return "redirect:/";  // Redirect to the main page or appropriate path
    }

        @GetMapping("/book-edit/{id}")
        public String editBookForm(@PathVariable Long id, Model model) {
        BookStore book = bookReposistory.findById(id).orElseThrow(() -> new IllegalArgumentException("Book not found"));
        model.addAttribute("book",book);
        return "edit-form";
        }

    @PostMapping("/edit-form/{id}")
    public String updateBook(@PathVariable Long id, @ModelAttribute BookStore bookStore) {
        BookStore existingBook = bookRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Book not found"));

        existingBook.setTitle(bookStore.getTitle());
        existingBook.setAuthor(bookStore.getAuthor());
        existingBook.setGenre(bookStore.getGenre());
        existingBook.setPrice(bookStore.getPrice());
        existingBook.setDot(bookStore.getDot());

        bookRepository.save(existingBook);

        return "redirect:/";  // Redirect to the list of books or any other desired page
    }
    @PostMapping("/book-delete/{id}")
    public String deleteBook(@PathVariable Long id) {
        bookRepository.deleteById(id);
        return "redirect:/"; // Redirect to the list of books or homepage after deletion
    }


}

package com.example.springBoot2.controllers;

import com.example.springBoot2.Repositories.BookRepository;
import com.example.springBoot2.models.Book;
import com.example.springBoot2.Repositories.BookRepository;
import com.example.springBoot2.models.Book;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/books")
public class BookController {
    private final BookRepository bookRepository;

    public BookController(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @GetMapping("/all")
    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }
    @GetMapping("/{id}")
    public Optional<Book> getBook(@PathVariable int id) {
        return bookRepository.findById(id);
    }
    @PostMapping("/add")
    public Book addItem(@RequestBody Book book) {
        return bookRepository.save(book);
    }
    @PutMapping("/{id}")
    public Book updateItem(@PathVariable int id, @RequestBody Book book) {
        return bookRepository.save(book);
    }
    @DeleteMapping("/{id}")
    public void deleteItem(@PathVariable int id) {
        bookRepository.deleteById(id);
    }
}
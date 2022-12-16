package com.example.jpa.book;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/books/")
public class BookController {
    public final BookRepository bookRepository;

    public BookController(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @GetMapping
    public List<Book> getBooks(){
        return bookRepository.findAll();
    }

    @PostMapping
    public Book createBook(@RequestBody Book book){
        return bookRepository.save(book);
    }
}

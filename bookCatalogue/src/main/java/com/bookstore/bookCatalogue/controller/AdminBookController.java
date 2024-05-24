package com.bookstore.bookCatalogue.controller;

import com.bookstore.bookCatalogue.model.Book;
import com.bookstore.bookCatalogue.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/book")
public class AdminBookController {

    @Autowired
    BookService service;

    @PostMapping
    public String addBook(@RequestBody Book book){
        return service.addBook(book);
    }

    @PutMapping("/{id}")
    public String updateBook(@PathVariable int id,@RequestBody Book book){
        return service.updateBook(id,book);
    }

    @DeleteMapping("/{id}")
    public String deleteBook(@PathVariable int id){
        return service.deleteBook(id);
    }

}

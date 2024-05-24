package com.bookstore.bookCatalogue.service;

import com.bookstore.bookCatalogue.dao.BookRepo;
import com.bookstore.bookCatalogue.model.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {

    @Autowired
    BookRepo repo;

    public List<Book> getAllBooks() {
        return repo.findAll();
    }

    public Book getBookById(int id) {
        return repo.findById(id).get();
    }

    public String addBook(Book book) {
        try {
            repo.save(book);
            return "Book Added Successfully";
        } catch (Exception e) {
            return "Could not add the book, please try again!";
        }
    }

    public String updateBook(int id, Book book) {
        try {
            Book oldBook=repo.findById(id).get();
            oldBook.setBookName(book.getBookName());
            oldBook.setAuthor(book.getAuthor());
            oldBook.setPrice(book.getPrice());
            repo.save(oldBook);
            return "Book Updated Successfully";
        } catch (Exception e) {
            return "Could not update the book, please try again!";
        }
    }

    public String deleteBook(int id) {
        try {
            repo.deleteById(id);
            return "Book Deleted Successfully";
        } catch (Exception e) {
            return "Could not delete the book, please try again!";
        }
    }
}

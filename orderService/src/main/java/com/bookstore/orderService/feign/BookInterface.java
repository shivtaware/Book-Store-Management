package com.bookstore.orderService.feign;

import com.bookstore.orderService.model.Book;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient("BOOKCATALOGUE")
public interface BookInterface {
    @GetMapping
    public List<Book> getAllBooks();

    @GetMapping("/books/{id}")
    public Book getBookById(@PathVariable int id);
}

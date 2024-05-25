package com.bookstore.orderService.model;

import lombok.Data;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
@Data
public class OrderDetails {
    Integer id;
    String firstName;
    String lastName;
    String emailId;
    String bookName;
    Integer quantity;
    Integer price;
    LocalDate orderDate;
    String status;
}

package com.bookstore.orderService.model;

import lombok.Data;
import org.springframework.stereotype.Component;

@Component
@Data
public class UserWrapper {
    Integer id;
    String firstName;
    String lastName;
    String emailID;
}

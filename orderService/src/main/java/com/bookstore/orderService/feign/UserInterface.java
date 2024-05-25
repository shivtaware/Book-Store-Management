package com.bookstore.orderService.feign;

import com.bookstore.orderService.model.UserWrapper;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


@FeignClient("USERSERVICE")
public interface UserInterface {
    @GetMapping("/user/{id}")
    public UserWrapper getUserById(@PathVariable int id);
}

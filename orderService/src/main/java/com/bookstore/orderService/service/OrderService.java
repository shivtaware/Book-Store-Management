package com.bookstore.orderService.service;

import com.bookstore.orderService.dao.OrderRepo;
import com.bookstore.orderService.model.OrderModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class OrderService {

    @Autowired
    OrderRepo repo;

    public String createOrder(OrderModel order) {

        try {
            order.setOrderDate(LocalDate.now());
            repo.save(order);
            return "Order placed successfully!";
        }
        catch (Exception e){
            return "Issue while placing the order, please try again!";
        }
    }

    public OrderModel getOrderDetails(int id) {
        return repo.findById(id).get();
    }
}

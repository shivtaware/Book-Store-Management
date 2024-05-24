package com.bookstore.orderService.dao;

import com.bookstore.orderService.model.OrderModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepo extends JpaRepository<OrderModel,Integer> {
}

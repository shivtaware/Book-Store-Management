package com.bookstore.orderService.service;

import com.bookstore.orderService.dao.OrderRepo;
import com.bookstore.orderService.feign.BookInterface;
import com.bookstore.orderService.feign.UserInterface;
import com.bookstore.orderService.model.Book;
import com.bookstore.orderService.model.OrderDetails;
import com.bookstore.orderService.model.OrderModel;
import com.bookstore.orderService.model.UserWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class OrderService {

    @Autowired
    OrderRepo repo;

    @Autowired
    UserInterface userInterface;

    @Autowired
    BookInterface bookInterface;

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

    public OrderDetails getOrderDetails(int id) {


        OrderModel orderModel= repo.findById(id).get();
        UserWrapper userWrapper=userInterface.getUserById(orderModel.getUserId());
        Book book=bookInterface.getBookById(orderModel.getBookId());

        OrderDetails orderDetails=new OrderDetails();
        orderDetails.setId(orderModel.getId());
        orderDetails.setFirstName(userWrapper.getFirstName());
        orderDetails.setLastName(userWrapper.getLastName());
        orderDetails.setEmailId(userWrapper.getEmailID());
        orderDetails.setBookName(book.getBookName());
        orderDetails.setQuantity(orderModel.getQuantity());
        orderDetails.setPrice(orderModel.getQuantity()* book.getPrice());
        orderDetails.setOrderDate(orderModel.getOrderDate());
        orderDetails.setStatus(orderModel.getStatus());

        return orderDetails;
    }
}

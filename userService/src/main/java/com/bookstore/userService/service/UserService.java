package com.bookstore.userService.service;

import com.bookstore.userService.dao.UserRepository;
import com.bookstore.userService.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    UserRepository repository;
    public String register(User user) {
        repository.save(user);
        return "Success!";
    }

    public User getUserById(int id) {
        return repository.findById(id).get();
    }

    public String login(String userName, String password) {
        try {
            User user = repository.findByUserName(userName);
            if (user.getPassword().equals(password))
                return "Successfully Logged in!";
            else
                return "Incorrect Username or Password!";
        } catch (Exception e) {
            return "User not found for specified username";
        }

    }
}

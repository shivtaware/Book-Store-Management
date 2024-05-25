package com.bookstore.userService.service;

import com.bookstore.userService.dao.UserRepository;
import com.bookstore.userService.model.User;
import com.bookstore.userService.model.UserWrapper;
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

    public UserWrapper getUserById(int id) {

        User user=repository.findById(id).get();
        UserWrapper userWrapper=new UserWrapper();
        userWrapper.setId(user.getId());
        userWrapper.setFirstName(user.getFirstName());
        userWrapper.setLastName(user.getLastName());
        userWrapper.setEmailID(user.getEmailID());

        return userWrapper;
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

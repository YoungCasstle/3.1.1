package com.task311.springboot.Service;

import com.task311.springboot.model.User;
import org.springframework.boot.autoconfigure.security.SecurityProperties;

import java.util.List;

public interface Service {
    List<SecurityProperties.User> getAllUser();

    void deleteUserById(int id);

    User updateUser(User user);

    void addUser(User user);

    User getUserById(int id);
}

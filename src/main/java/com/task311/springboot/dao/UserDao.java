package com.task311.springboot.dao;

import com.task311.springboot.model.User;
import org.springframework.boot.autoconfigure.security.SecurityProperties;

import java.util.List;

public interface UserDao {

    List<SecurityProperties.User> getAllUser();

    void deleteUserById(long id);

    void deleteUserById(int id);

    User updateUser(User user);

    void addUser(User user);

    User getUserById(long id);

    User getUserById(int id);
}

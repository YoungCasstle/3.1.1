package com.task311.springboot.Service;

import com.task311.springboot.dao.UserDao;
import com.task311.springboot.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@org.springframework.stereotype.Service
public class UserServiceImpl implements Service {

    private final UserDao userDao;

    @Autowired
    public UserServiceImpl(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public List<SecurityProperties.User> getAllUser() {
        return userDao.getAllUser();
    }

    @Transactional
    @Override
    public void deleteUserById(int id) {
        userDao.deleteUserById(id);
    }

    @Transactional
    @Override
    public User updateUser(User user) {
        return userDao.updateUser(user);
    }

    @Transactional
    @Override
    public void addUser(User user) {
        userDao.addUser(user);
    }

    @Override
    public User getUserById(int id) {
        return userDao.getUserById(id);
    }
}

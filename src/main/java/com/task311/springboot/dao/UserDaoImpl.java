package com.task311.springboot.dao;

import com.task311.springboot.model.User;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class UserDaoImpl implements UserDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<SecurityProperties.User> getAllUser() {
        return entityManager.createQuery("select u from User u", SecurityProperties.User.class).getResultList();
    }

    @Override
    public void deleteUserById(long id) {

    }

    @Override
    public void deleteUserById(int id) {
        entityManager.remove(entityManager.find(User.class, id));
    }

    @Override
    public User updateUser(User user) {
        return entityManager.merge(user);
    }

    @Override
    public void addUser(User user) {
        entityManager.persist(user);
    }

    @Override
    public User getUserById(long id) {
        return null;
    }

    @Override
    public User getUserById(int id) {
        return entityManager.find(User.class, id);
    }
}

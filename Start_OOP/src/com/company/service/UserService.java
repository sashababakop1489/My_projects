package com.company.service;

import com.company.dao.UserDao;
import com.company.entity.User;

public class UserService {

    private final UserDao userDao = new UserDao();

    public void create(User user) {
        userDao.create(user);
    }

    public void update(User user) {
        userDao.update(user);
    }

    public void delete(String id) {
        userDao.delete(id);
    }

    public User findById(String id) {
        return userDao.findById(id);
    }

    public User[] findAll() {
        return userDao.findAll();
    }
}

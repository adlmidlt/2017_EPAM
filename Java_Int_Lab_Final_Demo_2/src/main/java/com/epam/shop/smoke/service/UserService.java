package com.epam.shop.smoke.service;

import com.epam.shop.smoke.entity.User;

import java.util.List;

public interface UserService {
    void addUser(User user);
    User authenticate(User user);
    User getUserByLogin(String login);
    List<User> findAllUser();
}

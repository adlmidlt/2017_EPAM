package com.epam.shop_smoke.service;

import com.epam.shop_smoke.entity.User;

import java.util.List;

public interface UserService {
    void addUser(User user);
    User authenticate(User user);
    User getUserByLogin(String login);
    List<User> findAllUser();
}

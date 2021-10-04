package com.epam.shop.smoke.service.jdbc;

import com.epam.shop.smoke.entity.User;

import java.util.List;

public interface UserServiceJdbc {
    User findUserByLogin(String login);
    List<User> getAll();
    User getUserById(Long id);
    void deleteUserById(Long id);
    void addUser(User user);
    User authenticate(User user);
}

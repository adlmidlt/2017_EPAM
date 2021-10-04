package com.epam.shop.smoke.repository.jdbc;

import com.epam.shop.smoke.entity.User;

import java.util.List;

public interface UserRepositoryJdbc {
    User findUserByLogin(String login);
    List<User> getAll();
    User getUserById(Long id);
    void deleteUserById(Long id);
    void addUser(User user);
}

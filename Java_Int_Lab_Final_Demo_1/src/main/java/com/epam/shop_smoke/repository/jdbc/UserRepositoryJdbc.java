package com.epam.shop_smoke.repository.jdbc;

import com.epam.shop_smoke.entity.User;

import java.util.List;

public interface UserRepositoryJdbc {
    User findUserByLogin(String login);
    List<User> getAll();
    User getUserById(Long id);
    void deleteUserById(Long id);
    void addUser(User user);
}

package com.epam.shop_smoke.service.jdbc.impl;

import com.epam.shop_smoke.entity.User;
import com.epam.shop_smoke.repository.jdbc.UserRepositoryJdbc;
import com.epam.shop_smoke.service.jdbc.UserServiceJdbc;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceJdbcImpl implements UserServiceJdbc {
    private final UserRepositoryJdbc userRepositoryJdbc;

    @Autowired
    public UserServiceJdbcImpl(UserRepositoryJdbc userRepositoryJdbc) {
        this.userRepositoryJdbc = userRepositoryJdbc;
    }

    @Override
    public User findUserByLogin(String login) {
        return userRepositoryJdbc.findUserByLogin(login);
    }

    @Override
    public List<User> getAll() {
        return userRepositoryJdbc.getAll();
    }

    @Override
    public User getUserById(Long id) {
        return userRepositoryJdbc.getUserById(id);
    }

    @Override
    public void deleteUserById(Long id) {
        userRepositoryJdbc.deleteUserById(id);
    }

    @Override
    public void addUser(User user) {
        userRepositoryJdbc.addUser(user);
    }

    public User authenticate(User user) {

        User foundUser = findUserByLogin(user.getLogin());
/*        if (foundUser == null) {
            throw new UserNotFoundException("Такого пользователя не существует!");
        }
        if (!foundUser.getPassword().equals(user.getPassword())) {
            throw new InvalidPasswordException("Неверный пароль!");
        }*/
        return foundUser;
    }
}

package com.epam.shop_smoke.service.impl;

import com.epam.shop_smoke.entity.User;
import com.epam.shop_smoke.exception.InvalidPasswordException;
import com.epam.shop_smoke.exception.UserNotFoundException;
import com.epam.shop_smoke.repository.UserRepository;
import com.epam.shop_smoke.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;

    @Override
    public void addUser(User user) {
        userRepository.saveAndFlush(user);
    }

    @Override
    public User authenticate(User user) {
        User foundUser = getUserByLogin(user.getLogin());
        if (foundUser == null) {
            throw new UserNotFoundException("Такого пользователя не существует!");
        }
        if (!foundUser.getPassword().equals(user.getPassword())) {
            throw new InvalidPasswordException("Неверный пароль!");
        }
        return foundUser;
    }

    @Override
    public User getUserByLogin(String login) {
        return userRepository.getUserByLogin(login);
    }

    @Override
    public List<User> findAllUser() {
        return userRepository.findAll();
    }
}

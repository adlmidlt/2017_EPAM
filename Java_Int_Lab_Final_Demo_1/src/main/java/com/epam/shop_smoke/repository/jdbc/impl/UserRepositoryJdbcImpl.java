package com.epam.shop_smoke.repository.jdbc.impl;

import com.epam.shop_smoke.entity.User;
import com.epam.shop_smoke.repository.jdbc.UserRepositoryJdbc;
import com.epam.shop_smoke.repository.jdbc.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserRepositoryJdbcImpl implements UserRepositoryJdbc {
    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public UserRepositoryJdbcImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public User findUserByLogin(String login) {
        try {
            return jdbcTemplate.queryForObject("SELECT * FROM user WHERE login = ?", new UserMapper(), login);
        }catch (EmptyResultDataAccessException ignored) {
            return null;
        }
    }

    @Override
    public List<User> getAll() {
        return jdbcTemplate.query("SELECT * FROM user", new UserMapper());
    }

    @Override
    public User getUserById(Long id) {
        return jdbcTemplate.queryForObject("SELECT * FROM user WHERE id_user = ?", new Object[]{id}, new UserMapper());
    }

    @Override
    public void deleteUserById(Long id) {
        jdbcTemplate.queryForObject("DELETE FROM user WHERE id_user = ?", new Object[]{id}, new UserMapper());
    }

    @Override
    public void addUser(User user) {
        jdbcTemplate.update("INSERT INTO user(last_name, first_name, login, password) VALUES (?, ?, ?, ?)", user.getLastName(),
                user.getFirstName(), user.getLogin(), user.getPassword());
    }
}

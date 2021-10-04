package com.epam.shop.smoke.repository;

import com.epam.shop.smoke.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    User getUserByLogin(String login);
    User getUserByIdUser(Long id);
}

package com.epam.shop_smoke.repository;

import com.epam.shop_smoke.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    User getUserByLogin(String login);
    User getUserByIdUser(Long id);
}

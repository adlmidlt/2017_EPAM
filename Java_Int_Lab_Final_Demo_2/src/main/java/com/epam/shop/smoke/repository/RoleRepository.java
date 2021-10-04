package com.epam.shop.smoke.repository;

import com.epam.shop.smoke.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
    Role getRoleByNameRole(String nameRole);
}

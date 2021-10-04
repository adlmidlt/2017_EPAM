package com.epam.shop_smoke.repository;

import com.epam.shop_smoke.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
    Role getRoleByNameRole(String name);
}

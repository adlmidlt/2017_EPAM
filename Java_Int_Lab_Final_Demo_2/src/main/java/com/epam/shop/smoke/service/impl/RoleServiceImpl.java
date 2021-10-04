package com.epam.shop.smoke.service.impl;

import com.epam.shop.smoke.entity.Role;
import com.epam.shop.smoke.repository.RoleRepository;
import com.epam.shop.smoke.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoleServiceImpl implements RoleService {
    private final RoleRepository roleRepository;

    @Autowired
    public RoleServiceImpl(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    @Override
    public Role getRoleByNameRole(String nameRole) {
        return roleRepository.getRoleByNameRole(nameRole);
    }
}

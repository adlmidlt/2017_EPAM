package com.epam.shop_smoke.service.impl;

import com.epam.shop_smoke.entity.Role;
import com.epam.shop_smoke.repository.RoleRepository;
import com.epam.shop_smoke.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoleServiceImpl implements RoleService {
    @Autowired
    private RoleRepository roleRepository;

    @Override
    public Role getRoleByNameRole(String nameRole) {
        return roleRepository.getRoleByNameRole(nameRole);
    }
}

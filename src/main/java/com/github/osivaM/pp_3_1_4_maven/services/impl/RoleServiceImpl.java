package com.github.osivaM.pp_3_1_4_maven.services.impl;

import com.github.osivaM.pp_3_1_4_maven.models.Role;
import com.github.osivaM.pp_3_1_4_maven.repositories.RoleRepository;
import com.github.osivaM.pp_3_1_4_maven.services.RoleService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleServiceImpl implements RoleService {

    private final RoleRepository roleRepository;

    public RoleServiceImpl(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    @Override
    public List<Role> getAllRoles() {
        return roleRepository.findAll();
    }

}

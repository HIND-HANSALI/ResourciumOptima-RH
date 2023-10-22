package com.resourciumoptimarh.services;

import com.resourciumoptimarh.model.Role;
import com.resourciumoptimarh.repositories.RoleRepository;
import jakarta.inject.Inject;

public class RoleService {
    @Inject
    private RoleRepository roleRepository=new RoleRepository();
    public Role getRoleByName(String role) {
        Role role1=roleRepository.getRoleByName(role);
        return role1;
    }
}

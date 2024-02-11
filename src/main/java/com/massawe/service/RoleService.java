package com.massawe.service;

import com.massawe.dao.RoleDao;
import com.massawe.entity.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoleService {
    @Autowired
    private RoleDao roleDao;
    public Role createNewRole(Role role) {
        return roleDao.save(role);
    }
}

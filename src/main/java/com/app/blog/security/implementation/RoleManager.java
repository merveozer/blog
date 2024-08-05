package com.app.blog.security.implementation;

import com.app.blog.persistence.entity.RoleEntity;
import com.app.blog.security.dataAccess.RoleDao;
import com.app.blog.security.interfaces.RoleService;
import org.springframework.stereotype.Service;


@Service
public class RoleManager implements RoleService {

    private RoleDao roleDao;


    public RoleManager(RoleDao roleDao) {
        super();
        this.roleDao = roleDao;
    }


    public Iterable<RoleEntity> getAll() {
        return roleDao.findAll();
    }

}


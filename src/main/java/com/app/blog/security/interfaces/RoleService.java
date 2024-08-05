package com.app.blog.security.interfaces;

import com.app.blog.persistence.entity.RoleEntity;

public interface RoleService {
    public Iterable<RoleEntity> getAll();
}

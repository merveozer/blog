package com.app.blog.security.interfaces;

import com.app.blog.persistence.entity.UserEntity;

import java.util.List;

public interface UserService {
    List<UserEntity> getAll();
}

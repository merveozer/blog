package com.app.blog.user.interfaces.service;

import com.app.blog.user.interfaces.datamodel.UserBo;
import org.springframework.http.ResponseEntity;


public interface CreateUserService {
    ResponseEntity<UserBo> saveUser(UserBo user);
}

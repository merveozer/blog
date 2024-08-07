package com.app.blog.user.interfaces.service;

import com.app.blog.user.interfaces.datamodel.UserBo;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface RetrieveUserService {
    ResponseEntity<UserBo> getByUserName(String userName);
    ResponseEntity<List<UserBo>> getAllUsers();
}

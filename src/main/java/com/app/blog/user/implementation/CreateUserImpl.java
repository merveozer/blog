package com.app.blog.user.implementation;

import com.app.blog.persistence.entity.UserEntity;
import com.app.blog.security.dataAccess.UserDao;
import com.app.blog.user.interfaces.datamodel.UserBo;
import com.app.blog.user.interfaces.service.CreateUserService;
import com.app.blog.user.mapper.UserEntityMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class CreateUserImpl implements CreateUserService {
    private UserDao userDao;
    private UserEntityMapper userMapper;

    @Autowired
    public CreateUserImpl(UserDao userDao, UserEntityMapper userMapper) {
        this.userDao = userDao;
        this.userMapper = userMapper;
    }

    @Override
    public ResponseEntity<UserBo> saveUser(UserBo user) {
        UserEntity entity = userMapper.convert(user);
        userDao.save(entity);
        return new ResponseEntity<>(user, HttpStatus.CREATED);
    }

}

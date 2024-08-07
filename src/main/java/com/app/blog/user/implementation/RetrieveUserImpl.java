package com.app.blog.user.implementation;

import com.app.blog.persistence.entity.UserEntity;
import com.app.blog.security.dataAccess.UserDao;
import com.app.blog.user.interfaces.datamodel.UserBo;
import com.app.blog.user.interfaces.service.RetrieveUserService;
import com.app.blog.user.mapper.UserEntityMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RetrieveUserImpl implements RetrieveUserService {
    private UserDao userDao;
    private UserEntityMapper userMapper;

    @Autowired
    public RetrieveUserImpl(UserDao userDao, UserEntityMapper userMapper) {
        this.userDao = userDao;
        this.userMapper = userMapper;
    }

    @Override
    public ResponseEntity<UserBo> getByUserName(String userName) {
        UserEntity entity = userDao.getByUserName(userName);
        UserBo bo = userMapper.convert(entity);
        return new ResponseEntity<>(bo, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<List<UserBo>> getAllUsers() {
        List<UserEntity> userEntities = userDao.findAll();
        List<UserBo> userBos = userEntities.stream().map(e -> userMapper.convert(e)).toList();
        return new ResponseEntity<>(userBos, HttpStatus.OK);
    }
}

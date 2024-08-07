package com.app.blog.user.implementation;

import com.app.blog.persistence.entity.UserEntity;
import com.app.blog.security.dataAccess.UserDao;
import com.app.blog.user.interfaces.service.DeleteUserService;
import com.app.blog.user.mapper.UserEntityMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DeleteUserImpl implements DeleteUserService {

    private UserDao userDao;
    private UserEntityMapper userMapper;

    @Autowired
    public DeleteUserImpl(UserDao userDao, UserEntityMapper userMapper) {
        this.userDao = userDao;
        this.userMapper = userMapper;
    }
    @Override
    public boolean deleteByUserName(String userName) {
        UserEntity entity = userDao.getByUserName(userName);
        if (entity == null) {
            return false;
        }
        userDao.deleteByUserName(userName);
        return true;
    }
}

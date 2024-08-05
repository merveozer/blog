package com.app.blog.security.implementation;

import com.app.blog.persistence.entity.UserEntity;
import com.app.blog.security.dataAccess.UserDao;
import com.app.blog.security.interfaces.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserManager implements UserService {
    private UserDao userDao;

    @Autowired
    public UserManager(UserDao userDao) {
        super();
        this.userDao = userDao;
    }

    public List<UserEntity> getAllUsers() {
        return userDao.findAll();
    }

    public UserEntity saveOneUser(UserEntity newUser) {
        return userDao.save(newUser);
    }

    public UserEntity getOneUserById(Long userId) {
        return userDao.findById(userId).orElse(null);
    }

    public UserEntity updateOneUser(Long userId, UserEntity newUser) {
        Optional<UserEntity> user = userDao.findById(userId);
        if(user.isPresent()) {
            UserEntity foundUser = user.get();
            foundUser.setUserName(newUser.getUserName());
            foundUser.setPassword(newUser.getPassword());
            userDao.save(foundUser);
            return foundUser;
        }else
            return null;
    }

    public UserEntity getOneUserByUserName(String userName) {
        return userDao.findByUserName(userName);
    }

    public List<UserEntity> getAll() {
        List<UserEntity> users = new ArrayList<>();
        users = userDao.findAll();
        return users;
    }
}

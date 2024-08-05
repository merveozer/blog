package com.app.blog.security.implementation;

import com.app.blog.persistence.entity.UserEntity;
import com.app.blog.security.JwtUserDetails;
import com.app.blog.security.dataAccess.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public class UserDetailsManager implements UserDetailsService {
    @Autowired
    private UserDao userDao;

    public UserDetailsManager(UserDao userDao) {
        super();
        this.userDao = userDao;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserEntity user = userDao.findByUserName(username);
        return JwtUserDetails.create(user);
    }

    public UserDetails loadUserById(Long id) {
        UserEntity user = userDao.findById(id).get();
        return JwtUserDetails.create(user);
    }
}

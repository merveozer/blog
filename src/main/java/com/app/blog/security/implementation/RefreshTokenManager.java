package com.app.blog.security.implementation;

import com.app.blog.persistence.entity.UserEntity;
import com.app.blog.security.dataAccess.RefreshTokenDao;
import com.app.blog.security.entity.RefreshToken;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.Date;
import java.util.UUID;

@Service
public class RefreshTokenManager {
    @Value("${refresh.token.expires.in}")
    Long expireSeconds;

    private RefreshTokenDao refreshTokenDao;

    public RefreshTokenManager(RefreshTokenDao refreshTokenDao) {
        super();
        this.refreshTokenDao = refreshTokenDao;
    }

    public String createRefreshToken(UserEntity user) {
        RefreshToken token = refreshTokenDao.findByUserId(user.getUserId());
        if(token == null) {
            token =	new RefreshToken();
            token.setUser(user);
        }
        token.setToken(UUID.randomUUID().toString());
        token.setExpiryDate(Date.from(Instant.now().plusSeconds(expireSeconds)));
        refreshTokenDao.save(token);
        return token.getToken();
    }

    public boolean isRefreshExpired(RefreshToken token) {
        return token.getExpiryDate().before(new Date());
    }

    public RefreshToken getByUser(Long userId) {
        return refreshTokenDao.findByUserId(userId);
    }

}

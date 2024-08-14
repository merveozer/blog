package com.app.blog.security.dataAccess;

import com.app.blog.security.entity.RefreshToken;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RefreshTokenDao extends JpaRepository<RefreshToken, Long> {
    RefreshToken findByUserId(Long userId);
}

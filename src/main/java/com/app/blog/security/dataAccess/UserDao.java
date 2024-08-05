package com.app.blog.security.dataAccess;

import com.app.blog.persistence.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDao extends JpaRepository<UserEntity, Long> {
    UserEntity findByUserName(String userName);
}

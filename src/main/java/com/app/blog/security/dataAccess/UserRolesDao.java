package com.app.blog.security.dataAccess;

import com.app.blog.persistence.entity.UserRoleEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRolesDao extends JpaRepository<UserRoleEntity, Long> {
}

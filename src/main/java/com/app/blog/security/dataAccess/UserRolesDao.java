package com.app.blog.security.dataAccess;

import com.app.blog.persistence.entity.UserRoleEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRolesDao extends JpaRepository<UserRoleEntity, Long> {
}

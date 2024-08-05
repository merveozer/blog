package com.app.blog.security.dataAccess;

import com.app.blog.persistence.entity.RoleEntity;
import org.springframework.data.repository.CrudRepository;

public interface RoleDao extends CrudRepository<RoleEntity, Long> {

}

package com.app.blog.security.dataAccess;

import com.app.blog.persistence.entity.RoleEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleDao extends CrudRepository<RoleEntity, Long> {

}

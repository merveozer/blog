package com.app.blog.blog.dataAccess;

import com.app.blog.persistence.entity.BlogEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BlogDao extends JpaRepository<BlogEntity, Long> {
}

package com.app.blog.post.dataAcces;

import com.app.blog.persistence.entity.PostEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostDao extends JpaRepository<PostEntity, Long> {
}

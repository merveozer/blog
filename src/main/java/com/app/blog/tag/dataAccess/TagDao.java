package com.app.blog.tag.dataAccess;

import com.app.blog.persistence.entity.TagEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TagDao extends JpaRepository<TagEntity, Integer> {
}

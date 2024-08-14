package com.app.blog.post.dataAcces;

import com.app.blog.persistence.entity.PostEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PostDao extends JpaRepository<PostEntity, Long> {
    @Query(value =
            """
                    SELECT p.post_id, p.title, p.text
                    FROM posts p
                    JOIN blogs b ON p.blog_id = b.blog_id
                    JOIN users u ON b.user_id = u.id
                    WHERE u.userName = 'userName';""", nativeQuery = true)
    List<PostEntity> getByUserName(String userName);

    @Query(value = """
            SELECT p.post_id, p.title, p.text
            FROM posts p
            JOIN post_tags pt ON p.post_id = pt.post_id
            JOIN tags t ON pt.tag_id = t.tag_id
            WHERE t.name = 'tagName';
            """, nativeQuery = true)
    List<PostEntity> getByTagName(String tagName);
}

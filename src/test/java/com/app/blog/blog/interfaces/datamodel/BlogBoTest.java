package com.app.blog.blog.interfaces.datamodel;

import com.app.blog.post.interfaces.datamodel.PostBo;
import com.app.blog.user.interfaces.datamodel.UserBo;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class BlogBoTest {

    @Test
    public void testNoArgsConstructor() {
        BlogBo blogBo = new BlogBo();
        assertNull(blogBo.getUser());
        assertNull(blogBo.getPosts());
    }

    @Test
    public void testAllArgsConstructor() {
        UserBo userBo = new UserBo("username", "password", null);
        List<PostBo> posts = new ArrayList<>();
        BlogBo blogBo = new BlogBo(userBo, posts);
        assertEquals(userBo, blogBo.getUser());
        assertEquals(posts, blogBo.getPosts());
    }

    @Test
    public void testSetUser() {
        BlogBo blogBo = new BlogBo();
        UserBo userBo = new UserBo("username", "password", null);
        blogBo.setUser(userBo);
        assertEquals(userBo, blogBo.getUser());
    }

    @Test
    public void testSetPost() {
        BlogBo blogBo = new BlogBo();
        List<PostBo> posts = new ArrayList<>();
        blogBo.setPosts(posts);
        assertEquals(posts, blogBo.getPosts());
    }
}

package com.app.blog.blog.api;

import com.app.blog.blog.interfaces.datamodel.BlogBo;
import com.app.blog.blog.interfaces.service.CreateBlogService;
import com.app.blog.post.interfaces.datamodel.PostBo;
import com.app.blog.user.interfaces.datamodel.UserBo;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.junit.jupiter.api.Assertions.assertEquals;
public class CreateBlogApiTest {
    @Mock
    private CreateBlogService createBlogService;

    @InjectMocks
    private CreateBlogApi createBlogApi;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testCreateBlog() {
        BlogBo mockBlogBo = mockBlogBo();
        ResponseEntity<BlogBo> expectedResponse = new ResponseEntity<>(mockBlogBo, HttpStatus.CREATED);
        when(createBlogService.createBlog(any(BlogBo.class))).thenReturn(expectedResponse);
        ResponseEntity<BlogBo> actualResponse = createBlogApi.createBlog(mockBlogBo);
        assertEquals(expectedResponse, actualResponse);
    }

    public BlogBo mockBlogBo(){
        UserBo user = new UserBo();
        user.setUserName("Merve");
        user.setPassword("12345");
        BlogBo blogBo = new BlogBo();
        blogBo.setUser(user);
        PostBo post = new PostBo();
        post.setText("blog");
        post.setTitle("title");
        List<PostBo> posts = new ArrayList<>();
        posts.add(post);
        blogBo.setPosts(posts);
        return blogBo;
    }
}

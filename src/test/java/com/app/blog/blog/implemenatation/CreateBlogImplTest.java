package com.app.blog.blog.implemenatation;

import com.app.blog.blog.dataAccess.BlogDao;
import com.app.blog.blog.implementation.CreateBlogImpl;
import com.app.blog.blog.interfaces.datamodel.BlogBo;
import com.app.blog.blog.mapper.BlogEntityMapper;
import com.app.blog.persistence.entity.BlogEntity;
import com.app.blog.persistence.entity.PostEntity;
import com.app.blog.persistence.entity.UserEntity;
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

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import static org.mockito.ArgumentMatchers.any;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class CreateBlogImplTest {

    @Mock
    private BlogDao blogDao;

    @Mock
    private BlogEntityMapper mapper;

    @InjectMocks
    private CreateBlogImpl createBlogImpl;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testCreateBlog() {
        BlogBo mockBlogBo = mockBlogBo();
        BlogEntity mockBlogEntity = mockBlogEntity();

        when(mapper.convert(mockBlogBo)).thenReturn(mockBlogEntity);
        when(blogDao.save(any(BlogEntity.class))).thenReturn(mockBlogEntity);

        ResponseEntity<BlogBo> actualResponse = createBlogImpl.createBlog(mockBlogBo);

        assertEquals(HttpStatus.CREATED, actualResponse.getStatusCode());
        assertEquals(mockBlogBo, actualResponse.getBody());
        verify(mapper).convert(mockBlogBo);
        verify(blogDao).save(mockBlogEntity);
    }

    public BlogBo mockBlogBo(){
        BlogBo blogBo = new BlogBo();

        UserBo user = new UserBo();
        user.setUserName("Merve");
        user.setPassword("12345");
        blogBo.setUser(user);

        PostBo post = new PostBo();
        post.setText("blog");
        post.setTitle("title");
        List<PostBo> posts = new ArrayList<>();
        posts.add(post);
        blogBo.setPosts(posts);

        return blogBo;
    }

    public BlogEntity mockBlogEntity(){
        BlogEntity blogEntity = new BlogEntity();

        UserEntity user = new UserEntity();
        user.setUserName("Merve");
        user.setPassword("12345");
        blogEntity.setUser(user);

        PostEntity postEntity = new PostEntity();
        postEntity.setText("blog");
        postEntity.setTitle("title");
        List<PostEntity> posts = new ArrayList<>();
        posts.add(postEntity);
        blogEntity.setPosts(posts);

        return blogEntity;
    }
}

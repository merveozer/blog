package com.app.blog.post.api;

import com.app.blog.blog.interfaces.datamodel.BlogBo;
import com.app.blog.post.interfaces.datamodel.PostBo;
import com.app.blog.post.interfaces.service.CreatePostService;
import com.app.blog.tag.datamodel.TagBo;
import com.app.blog.user.interfaces.datamodel.UserBo;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.HashSet;
import java.util.Set;

import static org.mockito.Mockito.verify;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.junit.jupiter.api.Assertions.assertEquals;
public class CreatePostApiTest {
    @Mock
    private CreatePostService createPostService;

    @InjectMocks
    private CreatePostApi createPostApi;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testCreatePost() {
        PostBo mockPostBo = mockPostBo();
        ResponseEntity<PostBo> mockResponse = new ResponseEntity<>(mockPostBo, HttpStatus.CREATED);
        when(createPostService.createPost(any(PostBo.class))).thenReturn(mockResponse);
        ResponseEntity<PostBo> actualResponse = createPostApi.createPost(mockPostBo);
        assertEquals(HttpStatus.CREATED, actualResponse.getStatusCode());
        assertEquals(mockPostBo, actualResponse.getBody());
        verify(createPostService).createPost(mockPostBo);
    }

    private PostBo mockPostBo() {
        UserBo userBo = new UserBo("mockUser", "mockPassword", null);
        BlogBo blogBo = new BlogBo(userBo, null);
        Set<TagBo> tags = new HashSet<>();
        tags.add(new TagBo("tag1", 101, "Description 1"));
        tags.add(new TagBo("tag2", 102, "Description 2"));
        return new PostBo(1L, blogBo, "Sample Title", "Sample Text", tags);
    }
}

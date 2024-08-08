package com.app.blog.post.api;

import com.app.blog.post.interfaces.datamodel.PostBo;
import com.app.blog.post.interfaces.service.CreatePostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class CreatePostApi implements CreatePostService {
    CreatePostService createPostService;
    @Autowired
    public CreatePostApi(CreatePostService createPostService) {
        this.createPostService = createPostService;
    }

    @Override
    @PostMapping("/post")
    public ResponseEntity<PostBo> createPost(@RequestBody PostBo postBo) {
        return createPostService.createPost(postBo);
    }
}

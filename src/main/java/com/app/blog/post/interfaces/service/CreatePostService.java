package com.app.blog.post.interfaces.service;

import com.app.blog.post.interfaces.datamodel.PostBo;
import org.springframework.http.ResponseEntity;

public interface CreatePostService {
    ResponseEntity<PostBo> createPost(PostBo postBo);

}

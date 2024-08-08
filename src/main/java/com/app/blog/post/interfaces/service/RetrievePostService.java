package com.app.blog.post.interfaces.service;

import com.app.blog.post.interfaces.datamodel.PostBo;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface RetrievePostService {
    ResponseEntity<PostBo> getByUserName(String userName);
    ResponseEntity< List<PostBo>> getAllPosts();
}

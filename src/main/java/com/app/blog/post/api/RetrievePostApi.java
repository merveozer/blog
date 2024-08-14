package com.app.blog.post.api;

import com.app.blog.post.interfaces.datamodel.PostBo;
import com.app.blog.post.interfaces.service.RetrievePostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class RetrievePostApi implements RetrievePostService {
    RetrievePostService postService;
    @Autowired
    public RetrievePostApi(RetrievePostService postService) {
        this.postService = postService;
    }

    @Override
    @GetMapping("/user/{userName}")
    public ResponseEntity<List<PostBo>> getByUserName(@PathVariable String userName) {
        return postService.getByUserName(userName);
    }

    @Override
    @GetMapping("/posts")
    public ResponseEntity<List<PostBo>> getAllPosts() {
        return postService.getAllPosts();
    }

    @Override
    @GetMapping("/tag/{tagName}")
    public ResponseEntity<List<PostBo>> getByTagName(@PathVariable String tagName) {
        return postService.getByTagName(tagName);
    }
}

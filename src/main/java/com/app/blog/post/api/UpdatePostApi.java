package com.app.blog.post.api;

import com.app.blog.post.interfaces.datamodel.PostBo;
import com.app.blog.post.interfaces.service.UpdatePostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class UpdatePostApi implements UpdatePostService {
    UpdatePostService updatePostService;

    @Autowired
    public UpdatePostApi(UpdatePostService updatePostService) {
        this.updatePostService = updatePostService;
    }

    @Override
    @PatchMapping("/post")
    public ResponseEntity<PostBo> updatePost(PostBo postBo) {
        return updatePostService.updatePost(postBo);
    }
}

package com.app.blog.blog.api;

import com.app.blog.blog.interfaces.datamodel.BlogBo;
import com.app.blog.blog.interfaces.service.CreateBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class CreateBlogApi implements CreateBlogService {
    CreateBlogService createBlogService;

    @Autowired
    public CreateBlogApi(CreateBlogService createBlogService) {
        this.createBlogService = createBlogService;
    }

    @Override
    @PostMapping("/blog")
    public ResponseEntity<BlogBo> createBlog(BlogBo blogBo) {
        return createBlogService.createBlog(blogBo);
    }
}

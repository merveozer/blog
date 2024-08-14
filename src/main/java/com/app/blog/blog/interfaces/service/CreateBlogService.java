package com.app.blog.blog.interfaces.service;

import com.app.blog.blog.interfaces.datamodel.BlogBo;
import org.springframework.http.ResponseEntity;

public interface CreateBlogService {
    ResponseEntity<BlogBo> createBlog(BlogBo blogBo);
}

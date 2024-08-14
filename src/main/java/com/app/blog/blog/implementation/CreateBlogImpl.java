package com.app.blog.blog.implementation;

import com.app.blog.blog.dataAccess.BlogDao;
import com.app.blog.blog.interfaces.datamodel.BlogBo;
import com.app.blog.blog.interfaces.service.CreateBlogService;
import com.app.blog.blog.mapper.BlogEntityMapper;
import com.app.blog.persistence.entity.BlogEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class CreateBlogImpl implements CreateBlogService {
    private BlogDao blogDao;
    private BlogEntityMapper mapper;

    @Autowired
    public CreateBlogImpl(BlogDao blogDao, BlogEntityMapper mapper) {
        this.blogDao = blogDao;
        this.mapper = mapper;
    }

    @Override
    public ResponseEntity<BlogBo> createBlog(BlogBo blogBo) {
        BlogEntity entity = mapper.convert(blogBo);
        blogDao.save(entity);
        return new ResponseEntity<>(blogBo, HttpStatus.CREATED);
    }
}

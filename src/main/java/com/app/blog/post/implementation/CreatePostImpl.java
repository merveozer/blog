package com.app.blog.post.implementation;

import com.app.blog.persistence.entity.PostEntity;
import com.app.blog.post.dataAcces.PostDao;
import com.app.blog.post.interfaces.datamodel.PostBo;
import com.app.blog.post.interfaces.service.CreatePostService;
import com.app.blog.post.mapper.PostEntityMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class CreatePostImpl implements CreatePostService {
    private PostDao postDao;
    private PostEntityMapper mapper;
    @Autowired
    public CreatePostImpl(PostDao postDao, PostEntityMapper mapper) {
        this.postDao = postDao;
        this.mapper = mapper;
    }

    @Override
    public ResponseEntity<PostBo> createPost(PostBo postBo) {
        PostEntity entity = mapper.convert(postBo);
        postDao.save(entity);
        return new ResponseEntity<>(postBo, HttpStatus.CREATED);
    }
}

package com.app.blog.post.implementation;

import com.app.blog.persistence.entity.PostEntity;
import com.app.blog.post.dataAcces.PostDao;
import com.app.blog.post.interfaces.datamodel.PostBo;
import com.app.blog.post.interfaces.service.RetrievePostService;
import com.app.blog.post.mapper.PostEntityMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RetrievePostImpl implements RetrievePostService {

    private PostDao postDao;
    private PostEntityMapper mapper;

    @Autowired
    public RetrievePostImpl(PostDao postDao, PostEntityMapper mapper) {
        this.postDao = postDao;
        this.mapper = mapper;
    }


    @Override
    public ResponseEntity<List<PostBo>> getByUserName(String userName) {
        List<PostEntity> entityList = postDao.getByUserName(userName);
        List<PostBo> bos = mapper.convert(entityList);
        return new ResponseEntity<>(bos, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<List<PostBo>> getAllPosts() {
        List<PostEntity> entityList = postDao.findAll();
        List<PostBo> bos = mapper.convert(entityList);
        return new ResponseEntity<>(bos, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<List<PostBo>> getByTagName(String tagName) {
        List<PostEntity> entityList = postDao.getByTagName(tagName);
        List<PostBo> bos = mapper.convert(entityList);
        return new ResponseEntity<>(bos, HttpStatus.OK);
    }
}

package com.app.blog.post.implementation;

import com.app.blog.persistence.entity.PostEntity;
import com.app.blog.persistence.entity.TagEntity;
import com.app.blog.post.dataAcces.PostDao;
import com.app.blog.post.interfaces.datamodel.PostBo;
import com.app.blog.post.interfaces.service.UpdatePostService;
import com.app.blog.post.mapper.PostEntityMapper;
import com.app.blog.tag.mapper.TagEntityMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class UpdatePostImpl implements UpdatePostService {
    private PostDao postDao;
    PostEntityMapper mapper;
    TagEntityMapper tagEntityMapper;

    public UpdatePostImpl(PostDao postDao, PostEntityMapper mapper, TagEntityMapper tagEntityMapper) {
        this.postDao = postDao;
        this.mapper = mapper;
        this.tagEntityMapper = tagEntityMapper;
    }

    @Override
    public ResponseEntity<PostBo> updatePost(PostBo postBo) {
        PostEntity entity = postDao.getById(postBo.getId());
        Set<TagEntity> tagEntitySet = tagEntityMapper.convert(postBo.getTags());

        entity.setTags(tagEntitySet);
        entity.setText(postBo.getText());
        entity.setTitle(postBo.getTitle());
        postDao.save(entity);

        return new ResponseEntity<>(postBo, HttpStatus.OK);
    }
}

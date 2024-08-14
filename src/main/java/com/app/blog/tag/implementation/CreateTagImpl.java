package com.app.blog.tag.implementation;

import com.app.blog.persistence.entity.TagEntity;
import com.app.blog.tag.dataAccess.TagDao;
import com.app.blog.tag.datamodel.TagBo;
import com.app.blog.tag.interfaces.service.CreateTagService;
import com.app.blog.tag.mapper.TagEntityMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class CreateTagImpl implements CreateTagService {
    private TagDao dao;
    private TagEntityMapper mapper;

    @Autowired
    public CreateTagImpl(TagDao dao, TagEntityMapper mapper) {
        this.dao = dao;
        this.mapper = mapper;
    }

    @Override
    public ResponseEntity<TagBo> createTag(TagBo tagBo) {
        TagEntity entity = mapper.convert(tagBo);
        dao.save(entity);
        return new ResponseEntity<>(tagBo, HttpStatus.CREATED);
    }
}

package com.app.blog.tag.interfaces.service;

import com.app.blog.tag.datamodel.TagBo;
import org.springframework.http.ResponseEntity;

public interface CreateTagService {
    ResponseEntity<TagBo> createTag(TagBo tagBo);
}

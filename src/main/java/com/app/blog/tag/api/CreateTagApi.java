package com.app.blog.tag.api;

import com.app.blog.tag.datamodel.TagBo;
import com.app.blog.tag.interfaces.service.CreateTagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class CreateTagApi implements CreateTagService {
    CreateTagService service;

    @Autowired
    public CreateTagApi(CreateTagService service) {
        this.service = service;
    }

    @Override
    @PostMapping("/tag")
    public ResponseEntity<TagBo> createTag(TagBo tagBo) {
        return service.createTag(tagBo);
    }
}

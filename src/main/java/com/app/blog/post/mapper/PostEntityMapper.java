package com.app.blog.post.mapper;

import com.app.blog.persistence.entity.PostEntity;
import com.app.blog.post.interfaces.datamodel.PostBo;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PostEntityMapper {
    PostEntity convert(PostBo postBo);
    PostBo convert (PostEntity postEntity);
}

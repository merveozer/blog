package com.app.blog.post.mapper;

import com.app.blog.persistence.entity.PostEntity;
import com.app.blog.post.interfaces.datamodel.PostBo;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface PostEntityMapper {
    PostEntity convert(PostBo postBo);
    PostBo convert(PostEntity postEntity);
    List<PostBo> convert(List<PostEntity> entities);
}

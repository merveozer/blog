package com.app.blog.post.mapper;

import com.app.blog.persistence.entity.PostEntity;
import com.app.blog.post.interfaces.datamodel.PostBo;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface PostEntityMapper {
    @Mapping(source = "id", target = "postId")
    PostEntity convert(PostBo postBo);
    @Mapping(source = "postId", target = "id")
    PostBo convert(PostEntity postEntity);
    List<PostBo> convert(List<PostEntity> entities);
}

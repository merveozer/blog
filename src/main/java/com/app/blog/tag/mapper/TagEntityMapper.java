package com.app.blog.tag.mapper;

import com.app.blog.persistence.entity.TagEntity;
import com.app.blog.tag.datamodel.TagBo;
import org.mapstruct.Mapper;

import java.util.Set;

@Mapper(componentModel = "spring")
public interface TagEntityMapper {
    Set<TagEntity> convert(Set<TagBo> tagBos);
    TagBo convert(TagEntity tagEntity);
}

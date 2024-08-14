package com.app.blog.blog.mapper;

import com.app.blog.blog.interfaces.datamodel.BlogBo;
import com.app.blog.persistence.entity.BlogEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface BlogEntityMapper {
    BlogEntity convert(BlogBo blogBo);

    BlogBo convert(BlogEntity blogEntity);
}

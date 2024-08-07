package com.app.blog.user.mapper;

import com.app.blog.persistence.entity.UserEntity;
import com.app.blog.user.interfaces.datamodel.UserBo;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserEntityMapper {
    UserEntity convert(UserBo userBo);
    UserBo convert(UserEntity userEntity);
}

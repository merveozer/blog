package com.app.blog.blog.mapper;


import com.app.blog.blog.interfaces.datamodel.BlogBo;
import com.app.blog.persistence.entity.BlogEntity;
import com.app.blog.user.interfaces.datamodel.UserBo;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mapstruct.factory.Mappers;

import java.util.ArrayList;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
public class BlogEntityMapperTest {
    private BlogEntityMapper mapper;

    @BeforeEach
    public void setUp() {
        mapper = Mappers.getMapper(BlogEntityMapper.class);
    }

    @Test
    public void testConvertToBlogEntity() {
        UserBo userBo = new UserBo("username", "password", null);
        BlogBo blogBo = new BlogBo(userBo, new ArrayList<>());

        BlogEntity blogEntity = mapper.convert(blogBo);

        assertNotNull(blogEntity);
        assertEquals(blogBo.getUser().getUserName(), blogEntity.getUser().getUserName());
        assertEquals(blogBo.getPosts().size(), blogEntity.getPosts().size());
    }

    @Test
    public void testConvertToBlogBo() {
        BlogEntity blogEntity = new BlogEntity();
        blogEntity.setUser(new com.app.blog.persistence.entity.UserEntity());
        blogEntity.setPosts(new ArrayList<>());

        BlogBo blogBo = mapper.convert(blogEntity);
        assertNotNull(blogBo);
        assertEquals(blogEntity.getUser().getUserName(), blogBo.getUser().getUserName());
        assertEquals(blogEntity.getPosts().size(), blogBo.getPosts().size());
    }
}

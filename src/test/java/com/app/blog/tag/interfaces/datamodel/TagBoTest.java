package com.app.blog.tag.interfaces.datamodel;

import com.app.blog.persistence.entity.PostEntity;
import com.app.blog.tag.datamodel.TagBo;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TagBoTest {

    @Test
    void testTagBoConstructorAndGetters() {
        Set<PostEntity> posts = new HashSet<>();
        PostEntity postEntity = new PostEntity(1L, null, "Sample Title", "Sample Text", null);
        posts.add(postEntity);

        TagBo tagBo = new TagBo("Sample Tag", 123L, "Sample Description");

        assertEquals("Sample Tag", tagBo.getName());
        assertEquals(123L, tagBo.getCode());
        assertEquals("Sample Description", tagBo.getDescription());
    }

    @Test
    void testSetters() {
        TagBo tagBo = new TagBo("Sample Tag", 123L, "Sample Description");

        Set<PostEntity> posts = new HashSet<>();
        PostEntity postEntity = new PostEntity(1L, null, "Sample Title", "Sample Text", null);
        posts.add(postEntity);

        tagBo.setName("Sample Tag");
        tagBo.setCode(123L);
        tagBo.setDescription("Sample Description");

        assertEquals("Sample Tag", tagBo.getName());
        assertEquals(123L, tagBo.getCode());
        assertEquals("Sample Description", tagBo.getDescription());
    }
}


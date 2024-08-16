package com.app.blog.tag.mapper;

import com.app.blog.persistence.entity.TagEntity;
import com.app.blog.tag.datamodel.TagBo;
import org.junit.jupiter.api.Test;
import org.mapstruct.factory.Mappers;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TagEntityMapperTest {

    private final TagEntityMapper mapper = Mappers.getMapper(TagEntityMapper.class);

    @Test
    void testConvertTagBoToTagEntity() {
        TagBo tagBo = new TagBo("Sample Tag", 123L, "Sample Description");

        TagEntity tagEntity = mapper.convert(tagBo);

        assertEquals(tagBo.getName(), tagEntity.getName());
        assertEquals(tagBo.getCode(), tagEntity.getCode());
        assertEquals(tagBo.getDescription(), tagEntity.getDescription());
    }

    @Test
    void testConvertTagEntityToTagBo() {
        TagEntity tagEntity = new TagEntity(1, "Sample Tag", 123L, "Sample Description", new HashSet<>());
        TagBo tagBo = mapper.convert(tagEntity);

        assertEquals(tagEntity.getName(), tagBo.getName());
        assertEquals(tagEntity.getCode(), tagBo.getCode());
        assertEquals(tagEntity.getDescription(), tagBo.getDescription());
    }

    @Test
    void testConvertSetOfTagBoToSetOfTagEntity() {
        // Arrange
        TagBo tagBo1 = new TagBo("Sample Tag", 123L, "Sample Description");
        TagBo tagBo2 = new TagBo("Sample Tag", 123L, "Sample Description");
        Set<TagBo> tagBos = new HashSet<>();
        tagBos.add(tagBo1);
        tagBos.add(tagBo2);

        Set<TagEntity> tagEntities = mapper.convert(tagBos);

        assertEquals(2, tagEntities.size());
        for (TagEntity tagEntity : tagEntities) {
            if (tagEntity.getTagId() == 1) {
                assertEquals("Tag1", tagEntity.getName());
                assertEquals(100L, tagEntity.getCode());
                assertEquals("Description1", tagEntity.getDescription());
            } else if (tagEntity.getTagId() == 2) {
                assertEquals("Tag2", tagEntity.getName());
                assertEquals(200L, tagEntity.getCode());
                assertEquals("Description2", tagEntity.getDescription());
            }
        }
    }
}

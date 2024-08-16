package com.app.blog.post.mapper;

import com.app.blog.persistence.entity.PostEntity;
import com.app.blog.post.interfaces.datamodel.PostBo;
import com.app.blog.tag.datamodel.TagBo;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mapstruct.factory.Mappers;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
public class PostEntityMapperTest {

    private PostEntityMapper mapper;

    @BeforeEach
    public void setUp() {
        // Manuel olarak mapper oluşturma
        mapper = Mappers.getMapper(PostEntityMapper.class);
    }

    @Test
    public void testConvertPostBoToPostEntity() {
        Set<TagBo> tags = new HashSet<>();
        tags.add(new TagBo("Java", 101, "Java Tag Description"));
        PostBo postBo = new PostBo(1L, null, "Title", "Text", tags);

        PostEntity postEntity = mapper.convert(postBo);

        assertNotNull(postEntity);
        assertEquals(postBo.getId(), postEntity.getPostId());
        assertEquals(postBo.getTitle(), postEntity.getTitle());
        assertEquals(postBo.getText(), postEntity.getText());
        assertEquals(postBo.getTags().size(), postEntity.getTags().size());
    }

    @Test
    public void testConvertPostEntityToPostBo() {
        PostEntity postEntity = new PostEntity();
        postEntity.setPostId(1L);
        postEntity.setTitle("Title");
        postEntity.setText("Text");
        PostBo postBo = mapper.convert(postEntity);
    }
}


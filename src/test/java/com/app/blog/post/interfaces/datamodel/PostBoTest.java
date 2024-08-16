package com.app.blog.post.interfaces.datamodel;

import com.app.blog.blog.interfaces.datamodel.BlogBo;
import com.app.blog.tag.datamodel.TagBo;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import java.util.HashSet;
import java.util.Set;

public class PostBoTest {
    @Test
    public void testPostBoGettersAndSetters() {
        BlogBo blogBo = new BlogBo();
        Set<TagBo> tags = new HashSet<>();
        tags.add(new TagBo("tag1", 101, "Description 1"));
        tags.add(new TagBo("tag2", 102, "Description 2"));

        PostBo postBo = new PostBo();
        postBo.setId(1L);
        postBo.setBlogBo(blogBo);
        postBo.setTitle("Sample Title");
        postBo.setText("Sample Text");
        postBo.setTags(tags);

        assertEquals(1L, postBo.getId());
        assertEquals(blogBo, postBo.getBlogBo());
        assertEquals("Sample Title", postBo.getTitle());
        assertEquals("Sample Text", postBo.getText());
        assertEquals(tags, postBo.getTags());
    }

    @Test
    public void testPostBoConstructor() {
        BlogBo blogBo = new BlogBo();
        Set<TagBo> tags = new HashSet<>();
        tags.add(new TagBo("tag1", 101, "Description 1"));
        tags.add(new TagBo("tag2", 102, "Description 2"));

        PostBo postBo = new PostBo(1L, blogBo, "Sample Title", "Sample Text", tags);

        assertEquals(1L, postBo.getId());
        assertEquals(blogBo, postBo.getBlogBo());
        assertEquals("Sample Title", postBo.getTitle());
        assertEquals("Sample Text", postBo.getText());
        assertEquals(tags, postBo.getTags());
    }
}

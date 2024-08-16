package com.app.blog.tag.implementation;

import com.app.blog.persistence.entity.PostEntity;
import com.app.blog.persistence.entity.TagEntity;
import com.app.blog.tag.dataAccess.TagDao;
import com.app.blog.tag.datamodel.TagBo;
import com.app.blog.tag.mapper.TagEntityMapper;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@SpringJUnitConfig
public class CreateTagImplTest {

    @Mock
    private TagDao tagDao;

    @Mock
    private TagEntityMapper tagEntityMapper;

    @InjectMocks
    private CreateTagImpl createTagImpl;

    public CreateTagImplTest() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testCreateTag() {
        Set<PostEntity> posts = new HashSet<>();
        TagBo tagBo = new TagBo("Sample Tag", 1L, "Sample Description");
        TagEntity tagEntity = new TagEntity(1,"Sample Tag", 1L, "Sample Description",posts);

        when(tagEntityMapper.convert(tagBo)).thenReturn(tagEntity);
        when(tagDao.save(tagEntity)).thenReturn(tagEntity);

        ResponseEntity<TagBo> expectedResponse = new ResponseEntity<>(tagBo, HttpStatus.CREATED);

        ResponseEntity<TagBo> actualResponse = createTagImpl.createTag(tagBo);
        verify(tagEntityMapper).convert(tagBo);
        verify(tagDao).save(tagEntity);
        assertEquals(expectedResponse.getStatusCode(), actualResponse.getStatusCode());
        assertEquals(expectedResponse.getBody(), actualResponse.getBody());
    }
}

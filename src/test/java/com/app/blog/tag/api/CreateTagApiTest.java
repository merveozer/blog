package com.app.blog.tag.api;

import com.app.blog.tag.datamodel.TagBo;
import com.app.blog.tag.interfaces.service.CreateTagService;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@SpringJUnitConfig
public class CreateTagApiTest {

    @Mock
    private CreateTagService createTagService;

    @InjectMocks
    private CreateTagApi createTagApi;

    public CreateTagApiTest() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testCreateTag() {
        TagBo tagBo = new TagBo("Sample Tag", 1L, "Sample Description");
        ResponseEntity<TagBo> expectedResponse = new ResponseEntity<>(tagBo, HttpStatus.CREATED);

        when(createTagService.createTag(any(TagBo.class))).thenReturn(expectedResponse);
        ResponseEntity<TagBo> actualResponse = createTagApi.createTag(tagBo);

        assertEquals(expectedResponse.getStatusCode(), actualResponse.getStatusCode());
        assertEquals(expectedResponse.getBody(), actualResponse.getBody());
    }
}

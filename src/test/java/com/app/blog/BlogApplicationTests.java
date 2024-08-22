package com.app.blog;

import com.app.blog.blog.api.CreateBlogApi;
import com.app.blog.blog.interfaces.service.CreateBlogService;
import com.app.blog.persistence.entity.BlogEntity;
import com.app.blog.persistence.entity.PostEntity;
import com.app.blog.post.api.RetrievePostApi;
import com.app.blog.post.interfaces.service.RetrievePostService;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;
import org.testcontainers.containers.PostgreSQLContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest(classes = BlogApplication.class,
        webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
@Testcontainers(disabledWithoutDocker = true)
@ActiveProfiles("test")
class BlogApplicationTests {
    @Container
    private static final PostgreSQLContainer<?> POSTGRES_SQL_CONTAINER = new PostgreSQLContainer<>("postgres:9.6.8");
    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private CreateBlogService createBlogService;
    @Autowired
    private CreateBlogApi createBlogApi;
	@Autowired
	private RetrievePostService postService;
	@Autowired
	private RetrievePostApi postApi;

    @BeforeAll
    static void setup() {
        POSTGRES_SQL_CONTAINER.start();
    }

    @AfterAll
    static void tearDown() {
        POSTGRES_SQL_CONTAINER.close();
        assertThat(POSTGRES_SQL_CONTAINER.isRunning()).isFalse();
    }

    @BeforeEach
    void testIsContainerRunning() {
        assertThat(POSTGRES_SQL_CONTAINER.isRunning()).isTrue();
    }

    @Test
    void contextLoads() {
        assertThat(createBlogService).isNotNull();
        assertThat(createBlogApi).isNotNull();
		assertThat(postService).isNotNull();
		assertThat(postApi).isNotNull();
    }

    @Test
    void createBlog() throws Exception {
        BlogEntity blogEntity = new BlogEntity();
        blogEntity.setBlogId(1L);
        this.mockMvc.perform(post("/api/v1/blog")).andDo(print()).andExpect(status().isCreated());
    }

    @Test
    void getAllPosts() throws Exception {
		PostEntity postEntity = new PostEntity();
		postEntity.setPostId(1L);
		postEntity.setText("text");
		postEntity.setTitle("title");
        this.mockMvc.perform(get("/api/v1/posts")).andDo(print()).andExpect(status().isOk());

    }

}

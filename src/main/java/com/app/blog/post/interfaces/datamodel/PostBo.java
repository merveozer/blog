package com.app.blog.post.interfaces.datamodel;

import com.app.blog.blog.interfaces.datamodel.BlogBo;
import com.app.blog.tag.datamodel.TagBo;

import java.util.Set;

public class PostBo {
    private long id;
    private BlogBo blogBo;
    private String title;
    private String text;
    private Set<TagBo> tags;
    public PostBo() {
    }

    public PostBo(Long id, BlogBo blogBo, String title, String text, Set<TagBo> tags) {
        this.id = id;
        this.blogBo = blogBo;
        this.title = title;
        this.text = text;
        this.tags = tags;
    }
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public BlogBo getBlogBo() {
        return blogBo;
    }

    public void setBlogBo(BlogBo blogBo) {
        this.blogBo = blogBo;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Set<TagBo> getTags() {
        return tags;
    }

    public void setTags(Set<TagBo> tags) {
        this.tags = tags;
    }
}

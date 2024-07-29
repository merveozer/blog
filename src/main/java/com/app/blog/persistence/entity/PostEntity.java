package com.app.blog.persistence.entity;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "posts")
public class PostEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long post_id;
    @ManyToOne
    @JoinColumn(name = "blog_id")
    private BlogEntity blog;
    private String title;
    private String text;
    @ManyToMany
    @JoinTable(
            name = "post_tags",
            joinColumns = @JoinColumn(name = "post_id"),
            inverseJoinColumns = @JoinColumn(name = "tag_id")
    )
    private Set<TagEntity> tags = new HashSet<>();

    public PostEntity() {
    }

    public PostEntity(long post_id, BlogEntity blog, String title, String text, Set<TagEntity> tags) {
        this.post_id = post_id;
        this.blog = blog;
        this.title = title;
        this.text = text;
        this.tags = tags;
    }

    public long getPostId() {
        return post_id;
    }

    public void setPostId(long post_id) {
        this.post_id = post_id;
    }

    public BlogEntity getBlog() {
        return blog;
    }

    public void setBlog(BlogEntity blog) {
        this.blog = blog;
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

    public Set<TagEntity> getTags() {
        return tags;
    }

    public void setTags(Set<TagEntity> tags) {
        this.tags = tags;
    }
}

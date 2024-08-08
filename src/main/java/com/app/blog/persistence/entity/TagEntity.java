package com.app.blog.persistence.entity;

import javax.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "tags")
public class TagEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int tag_id;
    private String name;
    private long code;
    private String description;
    @ManyToMany(mappedBy = "tags")
    private Set<PostEntity> posts = new HashSet<>();

    public TagEntity(int tag_id, String name, long code, String description, Set<PostEntity> posts) {
        this.tag_id = tag_id;
        this.name = name;
        this.code = code;
        this.description = description;
        this.posts = posts;
    }

    public TagEntity() {
    }

    public int getTagId() {
        return tag_id;
    }

    public void setTagId(int tag_id) {
        this.tag_id = tag_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getCode() {
        return code;
    }

    public void setCode(long code) {
        this.code = code;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Set<PostEntity> getPosts() {
        return posts;
    }

    public void setPosts(Set<PostEntity> posts) {
        this.posts = posts;
    }
}

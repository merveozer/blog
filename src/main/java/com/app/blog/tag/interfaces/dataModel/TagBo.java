package com.app.blog.tag.interfaces.dataModel;

import com.app.blog.persistence.entity.PostEntity;

import java.util.HashSet;
import java.util.Set;

public class TagBo {
    private int tag_id;
    private String name;
    private long code;
    private String description;
    private Set<PostEntity> posts = new HashSet<>();

    public TagBo(int tag_id, String name, long code, String description, Set<PostEntity> posts) {
        this.tag_id = tag_id;
        this.name = name;
        this.code = code;
        this.description = description;
        this.posts = posts;
    }

    public int getTag_id() {
        return tag_id;
    }

    public void setTag_id(int tag_id) {
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

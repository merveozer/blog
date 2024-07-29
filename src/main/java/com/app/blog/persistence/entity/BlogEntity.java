package com.app.blog.persistence.entity;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "blogs")
public class BlogEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long blog_id;
    @OneToOne
    @JoinColumn(name = "user_id")
    private UserEntity user;

    @OneToMany(mappedBy = "blog", cascade = CascadeType.ALL)
    private List<PostEntity> posts = new ArrayList<>();

    public BlogEntity() {
    }

    public BlogEntity(Long blog_id, UserEntity user, List<PostEntity> posts) {
        this.blog_id = blog_id;
        this.user = user;
        this.posts = posts;
    }

    public Long getBlogId() {
        return blog_id;
    }

    public void setBlogId(Long id){
        this.blog_id = id;
    }

    public UserEntity getUser(){
        return user;
    }

    public void setUser(UserEntity user){
        this.user = user;
    }

    public List<PostEntity> getPosts() {
        return posts;
    }

    public void setPosts(List<PostEntity> posts) {
        this.posts = posts;
    }
}

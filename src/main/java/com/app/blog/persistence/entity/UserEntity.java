package com.app.blog.persistence.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "users")
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long user_id;
    private String userName;
    private String password;
    @OneToOne(mappedBy = "user", cascade = CascadeType.ALL)
    private BlogEntity blog;

    public UserEntity() {
    }

    public UserEntity(long user_id, String userName, String password, BlogEntity blog) {
        this.user_id = user_id;
        this.userName = userName;
        this.password = password;
        this.blog = blog;
    }

    public long getUserId() {
        return user_id;
    }

    public void setUserId(long user_id) {
        this.user_id = user_id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public BlogEntity getBlog() {
        return blog;
    }

    public void setBlog(BlogEntity blog) {
        this.blog = blog;
    }
}

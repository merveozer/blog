package com.app.blog.blog.interfaces.datamodel;

import com.app.blog.post.interfaces.datamodel.PostBo;
import com.app.blog.user.interfaces.datamodel.UserBo;

import java.util.List;

public class BlogBo {
    private UserBo user;
    private List<PostBo> posts;

    public BlogBo() {
    }

    public BlogBo(UserBo user, List<PostBo> posts) {
        this.user = user;
        this.posts = posts;
    }

    public UserBo getUser() {
        return user;
    }

    public void setUser(UserBo user) {
        this.user = user;
    }

    public List<PostBo> getPosts() {
        return posts;
    }

    public void setPosts(List<PostBo> posts) {
        this.posts = posts;
    }
}

package com.app.blog.blog.interfaces.datamodel;

import com.app.blog.post.interfaces.datamodel.PostBo;
import com.app.blog.user.interfaces.datamodel.UserBo;

import java.util.List;

public class BlogBo {
    UserBo user;
    List<PostBo> post;

    public BlogBo(UserBo user, List<PostBo> post) {
        this.user = user;
        this.post = post;
    }

    public UserBo getUser() {
        return user;
    }

    public void setUser(UserBo user) {
        this.user = user;
    }

    public List<PostBo> getPost() {
        return post;
    }

    public void setPost(List<PostBo> post) {
        this.post = post;
    }
}

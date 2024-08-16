package com.app.blog.user.interfaces.datamodel;

import com.app.blog.blog.interfaces.datamodel.BlogBo;

public class UserBo {
    private String userName;
    private String password;
    private BlogBo blog;
    public UserBo() {
    }
    public UserBo(String userName, String password, BlogBo blog) {
        this.userName = userName;
        this.password = password;
        this.blog = blog;
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

    public BlogBo getBlog() {
        return blog;
    }

    public void setBlog(BlogBo blog) {
        this.blog = blog;
    }
}

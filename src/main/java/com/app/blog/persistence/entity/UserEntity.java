package com.app.blog.persistence.entity;

import javax.persistence.*;

import java.util.Set;

@Entity
@Table(name = "users")
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String userName;
    private String password;
    @OneToOne(mappedBy = "user", cascade = CascadeType.ALL)
    private BlogEntity blog;
    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(name = "users_roles",
            joinColumns = {
                    @JoinColumn(name = "user_id")
            },
            inverseJoinColumns = {
                    @JoinColumn(name = "role_id")
            }
    )
    private Set<RoleEntity> role;

    public UserEntity() {
    }

    public UserEntity(long id, String userName, String password, BlogEntity blog, Set<RoleEntity> role) {
        this.id = id;
        this.userName = userName;
        this.password = password;
        this.blog = blog;
        this.role = role;
    }

    public long getUserId() {
        return id;
    }

    public void setUserId(long user_id) {
        this.id = user_id;
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

    public Set<RoleEntity> getRole() {
        return role;
    }

    public void setRole(Set<RoleEntity> role) {
        this.role = role;
    }
}

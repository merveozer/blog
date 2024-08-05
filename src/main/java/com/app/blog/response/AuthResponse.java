package com.app.blog.response;

import java.util.Set;

public class AuthResponse {
    private String message;
    private Long userId;
    private String accessToken;
    private String refreshToken;
    private Set role;

    public AuthResponse(String message, Long userId, String accessToken, String refreshToken, Set role) {
        this.message = message;
        this.userId = userId;
        this.accessToken = accessToken;
        this.refreshToken = refreshToken;
        this.role = role;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getAccessToken() {
        return accessToken;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }

    public String getRefreshToken() {
        return refreshToken;
    }

    public void setRefreshToken(String refreshToken) {
        this.refreshToken = refreshToken;
    }

    public Set getRole() {
        return role;
    }

    public void setRole(Set role) {
        this.role = role;
    }
}

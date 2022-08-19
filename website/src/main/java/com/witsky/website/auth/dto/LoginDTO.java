package com.witsky.website.auth.dto;

import com.witsky.website.auth.domain.LoginParam;

/**
 * @author YSJ
 * @date 2022/07/19 16:58
 */
public class  LoginDTO implements LoginParam {
    private String username;

    private String password;

    public String getUsername() {
        return username;
    }

    public LoginDTO setUsername(String username) {
        this.username = username;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public LoginDTO setPassword(String password) {
        this.password = password;
        return this;
    }
}

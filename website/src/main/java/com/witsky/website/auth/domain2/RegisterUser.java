package com.witsky.website.auth.domain2;

import org.springframework.stereotype.Component;

/**
 * @author YSJ
 * @date 2022/07/22 14:59
 */
@Component
public class RegisterUser {

    private String name;

    private String password;

    public String getName() {
        return name;
    }

    public RegisterUser setName(String name) {
        this.name = name;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public RegisterUser setPassword(String password) {
        this.password = password;
        return this;
    }

    public RegisterUser() {
    }

    public RegisterUser(String name, String password) {
        this.name = name;
        this.password = password;
    }
}

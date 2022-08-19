package com.witsky.website.auth.domain2;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;

/**
 * @author YSJ
 * @date 2022/07/22 15:33
 */
public class LocalUser implements UserDetails {


    private String username;

    private String password;

    private boolean enable;

    Collection<? extends GrantedAuthority> authorities;  //用户的权限集合

    public String getUsername() {
        return username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    public String getPassword() {
        return password;
    }

    public boolean isEnable() {
        return enable;
    }

    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    public LocalUser setUsername(String username) {
        this.username = username;
        return this;
    }

    public LocalUser setPassword(String password) {
        this.password = password;
        return this;
    }

    public LocalUser setEnable(boolean enable) {
        this.enable = enable;
        return this;
    }

    public LocalUser setAuthorities(Collection<? extends GrantedAuthority> authorities) {
        this.authorities = authorities;
        return this;
    }
}

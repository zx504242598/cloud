package com.zx.cloud.security.auth;

import com.zx.cloud.security.model.User;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Collections;

/**
 * @author zhaoxuan
 * @date 2020-07-20 14:33
 * 
 **/
public class AuthUser implements UserDetails {
    private static final long serialVersionUID = 1727289129265128962L;
    private final String id;
    private final String username;
    private final String password;
    private final Collection<? extends GrantedAuthority> authorities;


    public AuthUser(User user) {
        this.id=user.getId();
        this.username=user.getUsername();
        this.password=user.getPassword();
        this.authorities= Collections.singleton(new SimpleGrantedAuthority(user.getRole()));

    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
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

    @Override
    public String toString() {
        return "AuthUser{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", authorities=" + authorities +
                '}';
    }
}

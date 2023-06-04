package com.example.springbootdemo.security.details;

import org.apache.catalina.User;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;

import static java.util.Collection.*;
import static java.util.Collections.singletonList;

public class UserDetailsImpl implements UserDetails {

    public UserDetailsImpl(User user) {
        this.user = user;
    }

    private final User user;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {

        return singletonList(new SimpleGrantedAuthority("USER"));
    }

    @Override
    public String getPassword() {

        return user.getHashPassword();
    }

    @Override
    public String getUsername() {

        return user.getEmail();
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
}

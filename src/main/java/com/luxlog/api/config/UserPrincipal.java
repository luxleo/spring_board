package com.luxlog.api.config;

import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;

import java.util.List;

public class UserPrincipal extends User {
    private final Long userId;
    public UserPrincipal (com.luxlog.api.domain.User user){
        super(user.getEmail(), user.getPassword(), List.of(
                //new SimpleGrantedAuthority("ROLE_ADMIN"),
                //new SimpleGrantedAuthority("WRITE")));
                new SimpleGrantedAuthority("ROLE_ADMIN")));
        userId = user.getId();
    }

    public Long getUserId() {
        return userId;
    }
}

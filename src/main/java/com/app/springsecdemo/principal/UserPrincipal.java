package com.app.springsecdemo.principal;

import java.util.Arrays;
import java.util.Collection;


import org.jspecify.annotations.Nullable;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.app.springsecdemo.model.User;

public class UserPrincipal implements UserDetails {

    private User user;

    public UserPrincipal(User user){
        this.user=user;
    }
  
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return Arrays.asList(new SimpleGrantedAuthority("ROLE_USER"));
    }

    @Override
    public @Nullable String getPassword() {
        return user.getPassword();
    }

    @Override
    public String getUsername() {
        return user.getUsername();
    }
    
}

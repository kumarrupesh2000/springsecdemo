package com.app.springsecdemo.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.app.springsecdemo.model.User;
import com.app.springsecdemo.principal.UserPrincipal;
import com.app.springsecdemo.repository.UserRepo;

@Service
public class MyUserDetailsService implements UserDetailsService{

    @Autowired
    UserRepo repo;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        User user=repo.findByUsername(username);

        return new UserPrincipal(user);


        
    }
    
}

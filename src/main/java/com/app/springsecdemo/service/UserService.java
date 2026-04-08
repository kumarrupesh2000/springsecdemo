package com.app.springsecdemo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.app.springsecdemo.model.User;
import com.app.springsecdemo.repository.UserRepo;
@Service
public class UserService {


    @Autowired
    private UserRepo repo;
    public User saveUser(User user) {

        BCryptPasswordEncoder encoder=new BCryptPasswordEncoder(12);
        user.setPassword(encoder.encode(user.getPassword()));
        return repo.save(user);
    }



}

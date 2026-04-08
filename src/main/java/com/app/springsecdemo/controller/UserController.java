package com.app.springsecdemo.controller;

import org.springframework.web.bind.annotation.RestController;

import com.app.springsecdemo.model.User;
import com.app.springsecdemo.service.JwtService;
import com.app.springsecdemo.service.UserService;

import jakarta.servlet.http.HttpSession;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;




@RestController
public class UserController {

    @Autowired
    private UserService service;

    @Autowired
    private JwtService jwtService;

    @Autowired
    private HttpSession session;

    @Autowired
    AuthenticationManager authenticationManager;
    @GetMapping("/")
    public String homePage() {
        return "hello world "+session.getId();
    }

    @PostMapping("signup")
    public User singUp(@RequestBody User user) {
        System.out.println("Signup is called");
        return service.saveUser(user);
        
    }
    
    @PostMapping("login")
    public String login(@RequestBody User user){


        Authentication authentication=authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(user.getUsername(), user.getPassword()));

        if(authentication.isAuthenticated()){


            String token=jwtService.generateToken(user.getUsername());
            System.out.println(token);
            
            return token;
            
        }
        else{

            return "Failed";

        }
        
        

    }

    

    
}

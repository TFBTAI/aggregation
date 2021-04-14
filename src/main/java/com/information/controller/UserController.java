package com.information.controller;

import com.information.domain.User;
import com.information.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "http://localhost:8081")
@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping("/registered")
    @ResponseBody
    public int registered(String username,String password){
        return userService.registered(username,password);
    }

    @RequestMapping("/login")
    @ResponseBody
    public User login(String username,String password){
        return userService.login(username,password);
    }

    @RequestMapping("/updateCollection")
    @ResponseBody
    public void updateUserCollection(String username,String collection){
        userService.updateUserCollection(username,collection);
    }
}

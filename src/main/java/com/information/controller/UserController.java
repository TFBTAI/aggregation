package com.information.controller;

import com.information.domain.User;
import com.information.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@CrossOrigin(origins = "*")
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
    public HashMap<String, String> login(String username, String password){
        return userService.login(username,password);
    }

    @RequestMapping("/updateCollection")
    @ResponseBody
    public void updateUserCollection(String username,String collection){
        userService.updateUserCollection(username,collection);
    }

    @GetMapping("user/list")
    public List<User> listAll() {
        return userService.listAll();
    }
}

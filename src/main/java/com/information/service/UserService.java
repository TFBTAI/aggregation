package com.information.service;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.information.domain.User;
import com.information.mapper.UserMapper;
import org.apache.tomcat.util.buf.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
public class UserService {

    @Autowired
    private UserMapper userMapper;

    public int registered(String username,String password){
        String check = "^([a-z0-9A-Z]+[-|\\.]?)+[a-z0-9A-Z]@([a-z0-9A-Z]+(-[a-z0-9A-Z]+)?\\.)+[a-zA-Z]{2,}$";
        Pattern regex = Pattern.compile(check);
        Matcher matcher = regex.matcher(username);
        boolean isMatched = matcher.matches();
        User user = userMapper.getUser(username);
        if(user == null){
            if(isMatched){
                this.registeredByEmail(username,password);
            }else {
                this.registeredByPhone(username,password);
            }
            return 1;
        }else {
            return 0;
        }

    }

    public void registeredByPhone(String phone,String password){
        userMapper.setUserByPhone(phone,password);
    }

    public void registeredByEmail(String email,String password){
        userMapper.setUserByEmail(email,password);
    }

    public HashMap<String,String> login(String username,String password){
        HashMap<String,String> loginMessage = new HashMap<>();
        User user = userMapper.getUser(username);
        if(user != null){
            if(password.equals(user.getPassword())){
                userMapper.userLogin(username);
                loginMessage.put("message","登录成功");
                loginMessage.put("status","1");
                loginMessage.put("token",getToken(user));
                return loginMessage;
            }else {
                loginMessage.put("message","登录失败,密码错误");
                loginMessage.put("status","0");
                loginMessage.put("token",null);
                return loginMessage;
            }
        }else {
            loginMessage.put("message","登录失败,用户不存在");
            return loginMessage;
        }
    }

    public void updateUserCollection(String username,String collection){
        if(collection != ""){
            String[] collArray = collection.split(",");
            if("null".equals(collArray[0])){
                String[] array = new String[collArray.length-1];
                for(int i =0; i<array.length; i++){
                    array[i] = collArray[i+1];
                }
                StringBuffer collStr = new StringBuffer();
                for (String s : array) {
                    collStr.append(s+",");
                }
                collStr.deleteCharAt(collStr.length()-1);
                String collectionStr = new String(collStr);
                userMapper.updateUserCollection(username,collectionStr);
            }else {
                StringBuffer collStr = new StringBuffer(collection);
                collStr.deleteCharAt(0);
                String collectionStr = new String(collStr);
                userMapper.updateUserCollection(username,collectionStr);
            }
        }else {
            userMapper.updateUserCollection(username,"");
        }

    }

    public String getToken(User user){
        String  token = "";
        token = JWT.create().withAudience(user.getUserName()).sign(Algorithm.HMAC256(user.getPassword()));
        return token;
    }

    public List<User> listAll() {
        return userMapper.listAll();
    }
}

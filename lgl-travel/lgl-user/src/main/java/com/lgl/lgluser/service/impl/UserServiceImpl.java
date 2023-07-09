package com.lgl.lgluser.service.impl;

import com.lgl.lglcommon.entity.User;
import com.lgl.lgluser.mapper.UserMapper;
import com.lgl.lgluser.service.IEncryptService;
import com.lgl.lgluser.service.UserService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Base64;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private IEncryptService iEncryptService;

    @Override
    public List<User> all(){
        System.out.println("aaa");
        List<User> users =userMapper.all();
        System.out.println(users);
        return users;
    }
    @Override
    public User login(@Param("username") String username, @Param("password") String password){
        String pass=iEncryptService.getEncryptPassword(password);
        User user =userMapper.login(username,pass);
        return user;
    }
    @Override
    public int register(@RequestBody User user){
        //加密
        String pass= iEncryptService.getEncryptPassword(user.getPassword());
        user.setPassword(pass);
        return userMapper.register(user);
    }
    @Override
    public User findUserByUsername(@RequestParam("username") String username){
        return userMapper.findUserByUsername(username);
    }


}

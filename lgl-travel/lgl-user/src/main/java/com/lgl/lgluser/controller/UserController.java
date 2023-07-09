package com.lgl.lgluser.controller;


import com.alibaba.fastjson.JSON;
import com.lgl.lglcommon.entity.User;
import com.lgl.lglcommon.util.JwtUtil;
import com.lgl.lglcommon.util.ResultUtil;
import com.lgl.lgluser.service.UserService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/login")
    public ResultUtil login(@Param("username")String username,@Param("password")String password){
       User user= userService.login(username,password);
        if(user !=null){
            return new ResultUtil(200,"登录成功！",user);
        }
        return new ResultUtil(401,"登录失败");
    }

//    /**
//     * 退出登录
//     * @return
//     */
//    @RequestMapping("/logout")
//    public ResultUtil logout(){
//        return userService.logout();
//    }

    /**
     * 用户注册
     * @param user
     * @return
     */
    @PostMapping("/register")
    public ResultUtil register(@RequestBody User user){
        userService.register(user);
        return new ResultUtil(200,"注册成功");
    }
    @GetMapping("/findUserByUsername")
    public ResultUtil findUserByUsername(@RequestParam("username") String username){
        User user= userService.findUserByUsername(username);
        return new ResultUtil(200,user);
    }
//
//    /**
//     * 获取用户信息
//     * @return
//     */
//    @GetMapping("/userInfo")
//    @PreAuthorize("hasAuthority('sys:query')")
//    public ResponseResult userInfo(){
//        return userService.userInfo();
//    }
//    @PutMapping("/updatePassword")
//    @PreAuthorize("hasAuthority('sys:update')")
//    public ResponseResult updatePassword(@RequestParam String password){
//        return userService.updatePassword(password);
//    }

}

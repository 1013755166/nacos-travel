package com.lgl.lglclient.controller;

import com.alibaba.fastjson.JSON;
import com.lgl.lglclient.feign.UserClient;
import com.lgl.lglcommon.entity.Review;
import com.lgl.lglcommon.entity.User;
import com.lgl.lglcommon.util.JwtUtil;
import com.lgl.lglcommon.util.ResultUtil;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.UUID;


@Controller
public class UserController {
    @Autowired
    private UserClient userClient;

    @PostMapping("/login")
    public String login(@RequestParam("username") String username, @RequestParam("password") String password, HttpSession session){
        ResultUtil uu= userClient.login(username,password);
        session.setAttribute("user", uu.getData());
        session.setAttribute("flag","lw");
        return "redirect:http://localhost:7002/client/desAll";
    }
    @GetMapping("/tologin")
    public String tologin(){
        return "/login";
    }

    @PostMapping("/register")
    public String register(User user){
        userClient.register(user);
        return "/login";
    }
    @GetMapping("/toregister")
    public String toregister(){return "/register";}

    @GetMapping("/logout")
    public String logout(HttpSession session){
        session.removeAttribute("user");
        return "redirect:http://localhost:7002/client/tologin";
    }

}

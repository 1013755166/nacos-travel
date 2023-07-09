package com.lgl.lglclient.feign;


import com.lgl.lglcommon.entity.Review;
import com.lgl.lglcommon.entity.User;
import com.lgl.lglcommon.util.ResultUtil;
import org.apache.ibatis.annotations.Param;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

@Service
@FeignClient(name = "lgl-user")
public interface UserClient {
    @GetMapping("/login")
    public ResultUtil login(@RequestParam("username")String username,@RequestParam("password") String password);
    @GetMapping("/findUserByUsername")
    public ResultUtil findUserByUsername(@RequestParam("username") String username);

    @PostMapping("/register")
    public ResultUtil register(@RequestBody User user);




}

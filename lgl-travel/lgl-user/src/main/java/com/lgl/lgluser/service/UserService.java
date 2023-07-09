package com.lgl.lgluser.service;

import com.lgl.lglcommon.entity.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

public interface UserService {
    List<User> all();

    User login(@Param("username") String username, @Param("password") String password);
    int register(@RequestBody User user);
    User findUserByUsername(@RequestParam("username") String username);

}

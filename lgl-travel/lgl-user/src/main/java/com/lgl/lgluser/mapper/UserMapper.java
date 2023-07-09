package com.lgl.lgluser.mapper;

import com.lgl.lglcommon.entity.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Map;
@Mapper
public interface UserMapper {
    @Select("select * from user where username = #{username} and password=#{password}")
    User login(@Param("username") String username, @Param("password") String password);
    @Select("select * from user")
    List<User> all();
    @Insert("insert into user (username,password,email,phone) values (#{username},#{password},#{email},#{phone})")
    int register(@RequestBody User user);
    @Select("select * from user where username=#{username}")
    User findUserByUsername(@RequestParam("username") String username);
}

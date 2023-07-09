package com.lgl.lgldestination.mapper;

import com.lgl.lglcommon.entity.Destination;
import com.lgl.lglcommon.entity.Review;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Mapper
public interface DesMapper {
    //显示所有景区
    @Select("select * from destination")
    List<Destination> desAll();
    @Select("select * from destination where name=#{name}")
    List<Destination> searchdes(@RequestParam("name")String name);
    //根据proid查找评论
    @Select("select * from destination where id = #{id}")
    Destination desById(@RequestParam("id") Integer id);
}

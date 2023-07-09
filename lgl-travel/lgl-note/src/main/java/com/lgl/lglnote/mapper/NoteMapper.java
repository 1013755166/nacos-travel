package com.lgl.lglnote.mapper;

import com.lgl.lglcommon.dto.NoteDto;
import com.lgl.lglcommon.entity.Note;
import org.apache.ibatis.annotations.*;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Mapper
public interface NoteMapper {
    //查看所有人的游记
    @Select("select id,notename,username,description,createtime,modifytime from note,user where user.userid=note.userid")
    List<NoteDto> noteAll();
    //根据userid查找游记
    @Select("select * from note where userid = #{userid}")
    List<Note> noteByUserId(@RequestParam("userid") int userid);
    @Select("select id,notename,username,description,createtime,modifytime,location from note,user where id = #{id} and user.userid=note.userid")
    NoteDto noteById(@RequestParam("id") int id);
    //修改游记
    @Update("update note set notename=#{notename},location=#{location},description=#{description},modifytime=#{modifytime} where id=#{id}")
    int updateNote(@RequestBody Note note);
    //写游记
    @Insert("insert into note (userid,notename,description,location,createtime) values (#{userid},#{notename},#{description},#{location},#{createtime})")
    int addNote(@RequestBody Note note);
    //删除游记
    @Delete("DELETE note,review_nd FROM note LEFT JOIN review_nd ON note.id=review_nd.noteid WHERE note.id=#{id}")
    int delNote(@PathVariable("id") int id);
    @Select("select id,notename,username,description,createtime,modifytime from note,user where user.userid=note.userid and notename=#{notename}")
    List<NoteDto> search(@RequestParam("notename")String notename);
}

package com.lgl.lglnote.controller;

import com.lgl.lglcommon.dto.NoteDto;
import com.lgl.lglcommon.util.ResultUtil;
import com.lgl.lglnote.service.NoteService;
import com.lgl.lglcommon.entity.Note;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@RestController
public class NoteController {
    @Autowired
    private NoteService noteService;

    @GetMapping("/noteAll")
    public ResultUtil noteAll(){
        List<NoteDto> nn=noteService.noteAll();
        return new ResultUtil(200,nn);
    }
    @GetMapping("/noteByUserId")
    public ResultUtil noteByUserId(@RequestParam("userid") int userid){
        List<Note> nn=noteService.noteByUserId(userid);
        return new ResultUtil(200,nn);
    }
    @GetMapping("/noteById")
    public ResultUtil noteById(@RequestParam("id") int id){
        NoteDto nn=noteService.noteById(id);
        return new ResultUtil(200,nn);
    }
    @PostMapping("/updateNote")
    public ResultUtil updateNote(@RequestBody Note note){
        //生成创建时间
        Date date =new Date();
        SimpleDateFormat sdf =new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String nowTime = sdf.format(date);
        Timestamp timestamp=Timestamp.valueOf(nowTime);
        note.setModifytime(timestamp);
        noteService.updateNote(note);
        return new ResultUtil(200,"更新成功");
    }
    @PostMapping("/addNote")
    public ResultUtil addNote(@RequestBody Note note){
        //生成创建时间
        Date date =new Date();
        SimpleDateFormat sdf =new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String nowTime = sdf.format(date);
        Timestamp timestamp=Timestamp.valueOf(nowTime);
        note.setCreatetime(timestamp);
        noteService.addNote(note);
        return new ResultUtil(200,"添加游记成功");
    }
    @DeleteMapping("/delNote/{id}")
    public ResultUtil delNote(@PathVariable("id") int id){
        noteService.delNote(id);
        return new ResultUtil(200,"删除游记成功");
    }
    @GetMapping("/search")
    public ResultUtil search(@RequestParam("notename")String notename){
       List<NoteDto> ss=noteService.search(notename);
       return new ResultUtil(200,ss);
    }
}

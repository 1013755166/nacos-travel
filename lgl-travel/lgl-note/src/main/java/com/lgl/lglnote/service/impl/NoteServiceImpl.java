package com.lgl.lglnote.service.impl;

import com.lgl.lglcommon.dto.NoteDto;
import com.lgl.lglnote.mapper.NoteMapper;
import com.lgl.lglnote.service.NoteService;
import com.lgl.lglcommon.entity.Note;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Service
public class NoteServiceImpl implements NoteService {
    @Autowired
    private NoteMapper noteMapper;

    @Override
    public List<NoteDto> noteAll(){
        return noteMapper.noteAll();
    }
    @Override
    public List<Note> noteByUserId(@RequestParam("userid") int userid){
        return noteMapper.noteByUserId(userid);
    }
    @Override
    public NoteDto noteById(@RequestParam("id") int id){
        return noteMapper.noteById(id);
    }
    @Override
    public int updateNote(@RequestBody Note note){
        return noteMapper.updateNote(note);
    }
    @Override
    public int addNote(@RequestBody Note note){
        return noteMapper.addNote(note);
    }
    @Override
    public int delNote(@PathVariable("id") int id){
        return noteMapper.delNote(id);
    }
    @Override
    public List<NoteDto> search(@RequestParam("notename")String notename){return noteMapper.search(notename);}


}

package com.lgl.lglnote.service;

import com.lgl.lglcommon.dto.NoteDto;
import com.lgl.lglcommon.entity.Note;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

public interface NoteService {
    List<NoteDto> noteAll();
    List<Note> noteByUserId(@RequestParam("userid") int userid);
    NoteDto noteById(@RequestParam("id")int id);
    int updateNote(@RequestBody Note note);
    int addNote(@RequestBody Note note);
    int delNote(@PathVariable("id") int id);
    List<NoteDto> search(@RequestParam("notename")String notename);
}

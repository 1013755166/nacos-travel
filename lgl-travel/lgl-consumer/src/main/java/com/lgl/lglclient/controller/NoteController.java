package com.lgl.lglclient.controller;

import com.lgl.lglclient.feign.NoteClient;
import com.lgl.lglclient.feign.ReviewClient;
import com.lgl.lglcommon.entity.Note;
import com.lgl.lglcommon.entity.User;
import com.lgl.lglcommon.util.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

@Controller
public class NoteController {
    @Autowired
    private NoteClient noteClient;
    @Autowired
    private ReviewClient reviewClient;
    @GetMapping("/noteAll")
    public String noteAll(Model model){
        ResultUtil nn=noteClient.noteAll();
        model.addAttribute("noteAll",nn.getData());
        return "/note_list";
    }
    @PostMapping("/addNote")
    public String addNote(Note note){
        noteClient.addNote(note);
        return "redirect:http://localhost:7002/client/noteAll";
    }
    @GetMapping("/toaddNote")
    public String toaddNode(){
        return "/write_note";
    }
    @GetMapping("/noteById")
    public String noteById(int id,Model model){
        ResultUtil nn= noteClient.noteById(id);
        ResultUtil rn=reviewClient.reviewByNoteId(id);
        model.addAttribute("noteById",nn.getData());
        model.addAttribute("rn",rn.getData());
        return "/note";
    }
    @RequestMapping("/delNote/{id}")
    public String delNote(@PathVariable("id") int id){
        noteClient.delNote(id);
        return "redirect:http://localhost:7002/client/noteAll";
    }
    @GetMapping("/noteByUserId")
    public String noteByUserId(@RequestParam("userid") int userid,Model model){
        ResultUtil re= noteClient.noteByUserId(userid);
        model.addAttribute("re",re.getData());
        return "/my_note";
    }
    @PostMapping("/updateNote")
    public String updateNote(Note note){
        noteClient.updateNote(note);
        return "redirect:http://localhost:7002/client/noteByUserId?userid="+note.getUserid();
    }
    @GetMapping("/updateNote")
    public String update(@RequestParam("id") int id,Model model){
        ResultUtil ee=noteClient.noteById(id);
        model.addAttribute("ee",ee.getData());
        return "/write_note2";
    }
    @PostMapping("/search")
    public String search(@RequestParam("notename")String notename,Model model){
       ResultUtil ss= noteClient.search(notename);
       model.addAttribute("noteAll",ss.getData());
        return "/note_list";
    }

}

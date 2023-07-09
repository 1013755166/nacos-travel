package com.lgl.lglclient.feign;

import com.lgl.lglclient.feign.impl.NoteClientImpl;
import com.lgl.lglcommon.entity.Note;
import com.lgl.lglcommon.util.ResultUtil;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

@Service
@FeignClient(name = "lgl-note",fallback = NoteClientImpl.class)
public interface NoteClient {
    @GetMapping("/noteAll")
    public ResultUtil noteAll();

    @GetMapping("/noteByUserId")
    public ResultUtil noteByUserId(@RequestParam("userid") int userid);
    @GetMapping("/noteById")
    public ResultUtil noteById(@RequestParam("id") int id);

    @PostMapping("/updateNote")
    public ResultUtil updateNote(@RequestBody Note note);

    @PostMapping("/addNote")
    public ResultUtil addNote(@RequestBody Note note);

    @DeleteMapping("/delNote/{id}")
    public ResultUtil delNote(@PathVariable("id") int id);
    @GetMapping("/search")
    public ResultUtil search(@RequestParam("notename")String notename);
}

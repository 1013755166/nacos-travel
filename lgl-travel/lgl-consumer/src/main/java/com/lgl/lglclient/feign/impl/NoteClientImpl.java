package com.lgl.lglclient.feign.impl;

import com.lgl.lglclient.feign.NoteClient;
import com.lgl.lglcommon.entity.Note;
import com.lgl.lglcommon.util.ResultUtil;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

@Component
public class NoteClientImpl implements NoteClient {
    @Override
    public ResultUtil noteAll(){
        return new ResultUtil(500,"调用失败，服务降级");
    }
    @Override
    public ResultUtil noteByUserId(@RequestParam("userid") int userid){
        return new ResultUtil(500,"调用失败，服务降级");
    }
    @Override
    public ResultUtil noteById(@RequestParam("id") int id){
        return new ResultUtil(500,"调用失败，服务降级");
    }
    @Override
    public ResultUtil updateNote(@RequestBody Note note){
        return new ResultUtil(500,"调用失败，服务降级");
    }
    @Override
    public ResultUtil addNote(@RequestBody Note note){
        return new ResultUtil(500,"调用失败，服务降级");
    }
    @Override
    public ResultUtil delNote(@PathVariable("id") int id){
        return new ResultUtil(500,"调用失败，服务降级");
    }
    @Override
    public ResultUtil search(@RequestParam("notename")String notename){return new ResultUtil(500,"失败");}

}

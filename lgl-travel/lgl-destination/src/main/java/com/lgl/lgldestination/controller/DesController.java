package com.lgl.lgldestination.controller;

import com.lgl.lglcommon.entity.Destination;
import com.lgl.lglcommon.entity.Review;
import com.lgl.lglcommon.util.ResultUtil;
import com.lgl.lgldestination.service.DesService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class DesController {
    @Autowired
    private DesService desService;

    @GetMapping("/desById")
    public ResultUtil desById(@RequestParam("id") Integer id){
        Destination dd=desService.desById(id);
        return new ResultUtil(200,dd);
    }

    @GetMapping("/desAll")
    public ResultUtil desAll(){
        List<Destination> dd=desService.desAll();
        return new ResultUtil(200,dd);
    }
    @GetMapping("/searchdes")
   public ResultUtil searchdes(@RequestParam("name")String name){
        List<Destination> sc=desService.searchdes(name);
        return new ResultUtil(200,sc);
    }

}

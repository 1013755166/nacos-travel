package com.lgl.lglclient.controller;

import com.lgl.lglclient.feign.DesClient;
import com.lgl.lglclient.feign.ReviewClient;
import com.lgl.lglcommon.util.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class DesController {
    @Autowired
    private DesClient desClient;
    @Autowired
    private ReviewClient reviewClient;
    @GetMapping("/desAll")
    public String desAll(Model model){
       ResultUtil dd=desClient.desAll();
        model.addAttribute("des",dd.getData());
        return "/scenic_list";
    }
    @GetMapping("/desById")
    public String desById(@RequestParam("id") Integer id, Model model){
        ResultUtil dd=desClient.desById(id);
        ResultUtil rp=reviewClient.reviewByProId(id);
        model.addAttribute("desById",dd.getData());
        model.addAttribute("rp",rp.getData());
        return "/scenic";
    }
    @PostMapping("/searchdes")
    public String searchdes(@RequestParam("name")String name,Model model){
        ResultUtil ss= desClient.searchdes(name);
        model.addAttribute("des",ss.getData());
        return "/scenic_list";
    }
}

package com.lgl.lglclient.controller;

import com.alibaba.fastjson.JSON;
import com.lgl.lglclient.feign.ReviewClient;
import com.lgl.lglcommon.dto.RDDto;
import com.lgl.lglcommon.dto.RNDto;
import com.lgl.lglcommon.entity.Review;
import com.lgl.lglcommon.util.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
//@RestController
public class ReviewController {
    @Autowired
    private ReviewClient reviewClient;
    @GetMapping("/reviews")
    public String reviews(@RequestParam("userid")int userid, Model model){
        ResultUtil re= reviewClient.reviews(userid);
        model.addAttribute("review",re.getData());
        return "/note_comments";
    }
    @GetMapping("/proReview")
    public String proReview(@RequestParam("userid")int userid, Model model){
        ResultUtil re= reviewClient.proReview(userid);
        model.addAttribute("proreview",re.getData());
        return "/scenic_comments";
    }
    @GetMapping("/toscenic_comments")
    public String toprocomments(){return "/scenic_comments";}
    @RequestMapping("/delReview/{id}")
    public String deleteReview(@PathVariable("id") int id){
        reviewClient.deleteReview(id);
        return "redirect:http://localhost:7002/client/noteAll";
    }
    @PostMapping("/addNodeReview")
    public String addNodeReview(RNDto rnDto){
        reviewClient.addNoteReview(rnDto);
        return "redirect:http://localhost:7002/client/noteById?id="+rnDto.getNoteid();
    }


    @PostMapping("/addProReview")
    public String addProReview(RDDto rdDto){
        reviewClient.addProReview(rdDto);
        return "redirect:http://localhost:7002/client/desById?id="+rdDto.getDesid();
    }
}

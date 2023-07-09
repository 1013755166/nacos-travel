package com.lgl.lglclient.feign;

import com.lgl.lglclient.feign.impl.ReviewClientImpl;
import com.lgl.lglcommon.dto.RDDto;
import com.lgl.lglcommon.dto.RNDto;
import com.lgl.lglcommon.entity.Review;
import com.lgl.lglcommon.util.ResultUtil;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Service
@FeignClient(name = "lgl-review",fallback = ReviewClientImpl.class)
public interface ReviewClient {
    @GetMapping("/reviews")
    public ResultUtil reviews(@RequestParam("userid") int userid);
    @GetMapping("/proReview")
    public ResultUtil proReview(@RequestParam("userid")int userid);
    @DeleteMapping("/delReview/{id}")
    public ResultUtil deleteReview(@PathVariable("id") int id);
    @PostMapping("/addNoteReview")
    public ResultUtil addNoteReview(@RequestBody RNDto rnDto);
    @PostMapping("/addProReview")
    public ResultUtil addProReview(@RequestBody RDDto rdDto);
    @GetMapping("/reviewByNoteId")
    public ResultUtil reviewByNoteId(@RequestParam("noteid") int noteid);
    @GetMapping("/ByProId")
    public ResultUtil reviewByProId(@RequestParam("proid") int proid);
    @GetMapping("/ByUserId")
    public ResultUtil reviewByUserId(@RequestParam("userid") int userid);
}

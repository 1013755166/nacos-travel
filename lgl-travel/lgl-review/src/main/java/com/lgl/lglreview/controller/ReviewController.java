package com.lgl.lglreview.controller;

import com.lgl.lglcommon.dto.RDDto;
import com.lgl.lglcommon.dto.RNDto;
import com.lgl.lglcommon.dto.RNodeDto;
import com.lgl.lglcommon.entity.RND;
import com.lgl.lglcommon.entity.Review;
import com.lgl.lglcommon.util.ResultUtil;
import com.lgl.lglreview.service.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@RestController
public class ReviewController {
    @Autowired
    private ReviewService reviewService;

    /**
     * 通过用户id找评论
     * @param userid
     * @return
     */
    @GetMapping("/ByUserId")
    public ResultUtil reviewByUserId(@RequestParam("userid") int userid){
        Review review= reviewService.reviewByUserId(userid);
        return new  ResultUtil(200,review);
    }

    /**
     * 通过景区ID找评论
     * @param proid
     * @return
     */
    @GetMapping("/ByProId")
    public ResultUtil reviewByProId(@RequestParam("proid") int proid){
        List<RNodeDto> rp=reviewService.reviewByProId(proid);
        return new ResultUtil(200,rp);
    }

    @GetMapping("/reviews")
    public ResultUtil reviews(@RequestParam("userid") int userid){
//        int i= 1 / 0;
        List<Review> re= reviewService.reviews(userid);
        return new ResultUtil(200,re);
    }
    @GetMapping("/proReview")
    public ResultUtil proReview(@RequestParam("userid") int userid){
//        int i= 1 / 0;
        List<Review> re= reviewService.proReview(userid);
        return new ResultUtil(200,re);
    }

    /**
     * 删除指定评论
     * @param id
     * @return
     */
    @DeleteMapping("/delReview/{id}")
    public ResultUtil deleteReview(@PathVariable("id") int id){
        int re= reviewService.deleteReview(id);
        return new ResultUtil(200,re);
    }

    /**
     * 添加评论
     * @param rdDto
     * @return
     */
    @PostMapping("/addProReview")
    public ResultUtil addProReview(@RequestBody RDDto rdDto){
        //生成创建时间
        Date date =new Date();
        SimpleDateFormat sdf =new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String nowTime = sdf.format(date);
        Timestamp timestamp=Timestamp.valueOf(nowTime);
        //添加评论
        Review review=new Review();
        review.setReviewtime(timestamp);
        review.setUserid(rdDto.getUserid());
        review.setContent(rdDto.getContent());
        reviewService.addReview(review);

        RND rnd =new RND();
        rnd.setDesid(rdDto.getDesid());
        rnd.setReid(review.getId());
        reviewService.addProReview(rnd);
        return new ResultUtil(200,"添加景区评论成功");
    }
    @GetMapping("/reviewByNoteId")
    public ResultUtil reviewByNoteId(@RequestParam("noteid") int noteid){
        List<RNodeDto> rn= reviewService.reviewByNoteId(noteid);
        return new ResultUtil(200,rn);
    }
    @PostMapping("/addNoteReview")
    public ResultUtil addNoteReview(@RequestBody RNDto rnDto){
        //生成创建时间
        Date date =new Date();
        SimpleDateFormat sdf =new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String nowTime = sdf.format(date);
        Timestamp timestamp=Timestamp.valueOf(nowTime);
        //添加评论
        Review review=new Review();
        review.setReviewtime(timestamp);
        review.setUserid(rnDto.getUserid());
        review.setContent(rnDto.getContent());
        reviewService.addReview(review);

        RND rnd =new RND();
        rnd.setNoteid(rnDto.getNoteid());
        rnd.setReid(review.getId());
        reviewService.addNoteReview(rnd);
        return new ResultUtil(200,"添加评论成功");
    }
}

package com.lgl.lglreview.service.impl;

import com.lgl.lglcommon.dto.RDDto;
import com.lgl.lglcommon.dto.RNDto;
import com.lgl.lglcommon.dto.RNodeDto;
import com.lgl.lglcommon.entity.RND;
import com.lgl.lglcommon.entity.Review;
import com.lgl.lglreview.mapper.ReviewMapper;
import com.lgl.lglreview.service.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Service
public class ReviewServiceImpl implements ReviewService {
    @Autowired
    private ReviewMapper reviewMapper;
    @Override
    public Review reviewByUserId(@RequestParam int userid){
        return reviewMapper.reviewByUserId(userid);
    }
    @Override
    public List<RNodeDto> reviewByProId(@RequestParam int proid){
        return reviewMapper.reviewByProId(proid);
    }
    @Override
    public List<RNodeDto> reviewByNoteId(@RequestParam int noteid){
        return reviewMapper.reviewByNoteId(noteid);
    }
    @Override
    public int addReview(@RequestBody Review review){return reviewMapper.addReview(review);}
    @Override
    public int addProReview(@RequestBody RND rnd){
        return reviewMapper.addProReview(rnd);
    }
    @Override
    public int addNoteReview(@RequestBody RND rnd){
        return reviewMapper.addNoteReview(rnd);
    }
    @Override
    public List<Review> reviews(@RequestParam int userid){
        return reviewMapper.reviews(userid);
    }
    @Override
    public List<Review> proReview(@RequestParam int userid){
        return reviewMapper.proReview(userid);
    }
    @Override
     public int deleteReview(@PathVariable("id") int id){
       return reviewMapper.deleteReview(id);
    }

}

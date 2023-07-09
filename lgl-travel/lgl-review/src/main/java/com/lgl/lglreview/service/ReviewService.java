package com.lgl.lglreview.service;

import com.lgl.lglcommon.dto.RDDto;
import com.lgl.lglcommon.dto.RNDto;
import com.lgl.lglcommon.dto.RNodeDto;
import com.lgl.lglcommon.entity.RND;
import com.lgl.lglcommon.entity.Review;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

public interface ReviewService {
    Review reviewByUserId(@RequestParam int userid);
    List<RNodeDto> reviewByProId(@RequestParam int proid);
    List<RNodeDto> reviewByNoteId(@RequestParam int noteid);
    int addReview(@RequestBody Review review);
    int addProReview(@RequestBody RND rnd);
    int addNoteReview(@RequestBody RND rnd);
    List<Review> reviews(@RequestParam int userid);
    List<Review> proReview(@RequestParam int userid);
    int deleteReview(@PathVariable("id") int id);
}

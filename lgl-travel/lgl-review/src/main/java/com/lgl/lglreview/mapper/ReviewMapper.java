package com.lgl.lglreview.mapper;

import com.lgl.lglcommon.dto.RDDto;
import com.lgl.lglcommon.dto.RNDto;
import com.lgl.lglcommon.dto.RNodeDto;
import com.lgl.lglcommon.entity.RND;
import com.lgl.lglcommon.entity.Review;
import org.apache.ibatis.annotations.*;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Mapper
public interface ReviewMapper {
    //根据userid查找评论
    @Select("select * from review where userid = #{userid}")
    Review reviewByUserId(@RequestParam int userid);
    //根据proid查找评论
    @Select("SELECT username,content,reviewtime FROM (review r LEFT JOIN review_nd n ON r.id=n.reid) LEFT JOIN `user` u ON u.userid=r.userid WHERE desid=#{desid}")
    List<RNodeDto> reviewByProId(@RequestParam int proid);
    //根据nodeid查找评论
    @Select("SELECT username,content,reviewtime FROM (review r LEFT JOIN review_nd n ON r.id=n.reid) LEFT JOIN `user` u ON u.userid=r.userid WHERE noteid=#{noteid}")
    List<RNodeDto> reviewByNoteId(@RequestParam int noteid);
    @Select("SELECT review.* FROM review,review_nd WHERE review.id=review_nd.reid AND desid is not null and userid=#{userid}")
    List<Review> proReview(@RequestParam int userid);
    @Select("SELECT review.* FROM review,review_nd WHERE review.id=review_nd.reid AND noteid is not null and userid=#{userid}")
    List<Review> reviews(@RequestParam int userid);
    //写景区评论
    int addReview(@RequestBody Review review);
    @Insert("insert into review_nd(reid,desid) values(#{reid},#{desid})")
    int addProReview(@RequestBody RND rnd);
    @Insert("insert into review_nd(reid,noteid) values(#{reid}, #{noteid})")
    //写游记评论
    int addNoteReview(@RequestBody RND rnd);
    //删除评论
    @Delete("DELETE review,review_nd FROM review LEFT JOIN review_nd ON review.id=review_nd.reid WHERE review.id=#{id}")
    int deleteReview(@PathVariable("id") int id);
}

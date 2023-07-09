package com.lgl.lglclient.feign.impl;

import com.lgl.lglclient.feign.ReviewClient;
import com.lgl.lglcommon.dto.RDDto;
import com.lgl.lglcommon.dto.RNDto;
import com.lgl.lglcommon.entity.Review;
import com.lgl.lglcommon.util.ResultUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Component
@Slf4j
public class ReviewClientImpl implements ReviewClient {
    @Override
    public ResultUtil reviews(@RequestParam("userid")int userid){
        return new ResultUtil(500,"调用失败，服务降级");
    }
    @Override
    public ResultUtil proReview(@RequestParam("userid")int userid){
        log.error("降级");
        return new ResultUtil(500,"调用失败，服务降级");
    }
    @Override
    public ResultUtil deleteReview(@PathVariable("id") int id){
        return new ResultUtil(500,"调用失败，服务降级");
    }
    @Override
    public ResultUtil addNoteReview(@RequestBody RNDto rnDto){
        return new ResultUtil(500,"调用失败，服务降级");
    }
    @Override
    public ResultUtil addProReview(@RequestBody RDDto rdDto){
        return new ResultUtil(500,"调用失败，服务降级");
    }
    @Override
    public ResultUtil reviewByNoteId(@RequestParam("noteid") int noteid){
        return new ResultUtil(500,"调用失败，服务降级");
    }
    @Override
    public ResultUtil reviewByProId(@RequestParam("proid") int proid){
        return new ResultUtil(500,"调用失败，服务降级");
    }
    @Override
    public ResultUtil reviewByUserId(@RequestParam("userid") int userid){return new ResultUtil(500,"调用失败");}
}

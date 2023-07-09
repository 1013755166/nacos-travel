package com.lgl.lglclient.feign;

import com.lgl.lglcommon.entity.Destination;
import com.lgl.lglcommon.entity.Review;
import com.lgl.lglcommon.util.ResultUtil;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Service
@FeignClient(name = "lgl-des")
public interface DesClient {
    @GetMapping("/desAll")
    public ResultUtil desAll();
    @GetMapping("/desById")
    public ResultUtil desById(@RequestParam("id") Integer id);
    @GetMapping("/searchdes")
    public ResultUtil searchdes(@RequestParam("name")String name);
}

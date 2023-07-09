package com.lgl.lgldestination.service;

import com.lgl.lglcommon.entity.Destination;
import com.lgl.lglcommon.entity.Review;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

public interface DesService {

    List<Destination> desAll();
    Destination desById(@RequestParam("id") Integer id);
    List<Destination> searchdes(@RequestParam("name")String name);
}

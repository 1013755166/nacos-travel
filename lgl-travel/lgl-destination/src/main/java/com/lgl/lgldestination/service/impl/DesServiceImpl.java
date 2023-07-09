package com.lgl.lgldestination.service.impl;

import com.lgl.lglcommon.entity.Destination;
import com.lgl.lglcommon.entity.Review;
import com.lgl.lgldestination.mapper.DesMapper;
import com.lgl.lgldestination.service.DesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Service
public class DesServiceImpl implements DesService {
    @Autowired
    private DesMapper desMapper;
    @Override
    public List<Destination> searchdes(@RequestParam("name")String name){return desMapper.searchdes(name);}

    @Override
    public Destination desById(@RequestParam("id") Integer id){
        return desMapper.desById(id);
    }

    @Override
    public List<Destination> desAll(){
        return desMapper.desAll();
    }

}

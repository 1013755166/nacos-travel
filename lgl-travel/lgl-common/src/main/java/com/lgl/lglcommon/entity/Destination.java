package com.lgl.lglcommon.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("destination")
public class Destination {
    private int id;
    private String name;
    private String description;
    private String location;
}

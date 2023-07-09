package com.lgl.lglcommon.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("note")
public class Note {
    //    @TableId(value = "userid", type = IdType.AUTO)
    private int id;
    private int userid;
    private String notename;
    private String description;
    private String location;
    private Date createtime;
    private Date modifytime;
}

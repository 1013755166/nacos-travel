package com.lgl.lglcommon.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("review_nd")
public class RND {
    private int id;
    private int noteid;
    private int desid;
    private int reid;
}

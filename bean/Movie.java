package com.nsu.movie2023.bean;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName(value = "film_list")
public class Movie {
    @TableId(value = "FID", type = IdType.AUTO)
    private int fid;
    private String title;
    private String category;
}

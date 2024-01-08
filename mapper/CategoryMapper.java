package com.nsu.movie2023.mapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.nsu.movie2023.bean.Category;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;
@Mapper
@Repository
public interface CategoryMapper extends BaseMapper<Category> {
}
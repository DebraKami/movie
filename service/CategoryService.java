package com.nsu.movie2023.service;

import com.nsu.movie2023.bean.Category;
import com.nsu.movie2023.mapper.CategoryMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {
    @Autowired
    private CategoryMapper categoryMapper;
    public List<Category> getAll(){
        return categoryMapper.selectList(null);
    }
}

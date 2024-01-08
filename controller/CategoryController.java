package com.nsu.movie2023.controller;
import com.nsu.movie2023.bean.Category;
import com.nsu.movie2023.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import java.util.List;
@Controller
public class CategoryController {
    @Autowired
    private CategoryService categoryService;
    @RequestMapping("/categories")
    public String getAll(Model model){
        List<Category> categories=categoryService.getAll();
        model.addAttribute("categories",categories);
        return "category";
    }
}
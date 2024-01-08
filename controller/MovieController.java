package com.nsu.movie2023.controller;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.nsu.movie2023.bean.Movie;
import com.nsu.movie2023.bean.MovieDetail;
import com.nsu.movie2023.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import java.util.List;
@Controller
public class MovieController {
    @Autowired
    private MovieService movieService;
    @RequestMapping("/title")
    public String getByTitle(Model model,String title,int page){
        if(title==null)
            title="";
        IPage<Movie> moviePage=movieService.getByTitle(title,page);
        model.addAttribute("moviePage",moviePage);
        return "movies";
    }
    @RequestMapping("/category/{category}")
    public String getByCategory(Model model, @PathVariable("category") String
            category, int page){
        if(category==null)
            category="Action";
        IPage<Movie> moviePage=movieService.getByCategory(category,page);
        model.addAttribute("moviePage",moviePage);
        return "movies";
    }
    @RequestMapping("/{id}")
    public String getById(@PathVariable("id") int id,Model model){
        MovieDetail movieDetail=movieService.getById(id);
        model.addAttribute("movie",movieDetail);
        return "moviedetail";
    }
}
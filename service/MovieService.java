package com.nsu.movie2023.service;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.nsu.movie2023.bean.Movie;
import com.nsu.movie2023.bean.MovieDetail;
import com.nsu.movie2023.mapper.MovieDetailMapper;
import com.nsu.movie2023.mapper.MovieMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
@Service
public class MovieService {
    @Autowired
    private MovieMapper movieMapper;
    @Autowired
    private MovieDetailMapper movieDetailMapper;
    private int pageSize=20;
    public List<Movie> getAll(){
        QueryWrapper<Movie> queryWrapper=new QueryWrapper<Movie>();
        queryWrapper.last("limit 50");
        return movieMapper.selectList(queryWrapper);
    }
    public IPage<Movie> getByTitle(String title,int page){
        Page<Movie> moviePage=new Page(page,pageSize);
        QueryWrapper<Movie> queryWrapper=new QueryWrapper<>();
        queryWrapper.like("title",title);
        return movieMapper.selectPage(moviePage,queryWrapper);
    }
    public IPage<Movie> getByCategory(String category,int page){
        Page<Movie> moviePage=new Page(page,pageSize);
        QueryWrapper<Movie> queryWrapper=new QueryWrapper<>();
        queryWrapper.eq("category",category);
        return movieMapper.selectPage(moviePage,queryWrapper);
    }
    public MovieDetail getById(int film_id){
        MovieDetail movieDetail=movieDetailMapper.getById(film_id);
        return movieDetail;
    }
}
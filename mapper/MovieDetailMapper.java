package com.nsu.movie2023.mapper;

import com.nsu.movie2023.bean.Movie;
import com.nsu.movie2023.bean.MovieDetail;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface MovieDetailMapper {
    @Select("select f.*,fl.price,fl.category,fl.FID,fl.actors from film f,film_list fl where FID=film_id and film_id=#{film_id}")
    MovieDetail getById(int film_id);
}

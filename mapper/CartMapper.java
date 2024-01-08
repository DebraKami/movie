package com.nsu.movie2023.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.nsu.movie2023.bean.Cart;
import com.nsu.movie2023.bean.MovieDetail;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface CartMapper extends BaseMapper<Cart>{
    @Select("select f.*,c.count from film f,cart c where f.film_id=c.film_id and c.customer_id=#{customer_id}")
    List<MovieDetail> getById(int customer_id);
    @Select("select * from cart where film_id=#{filmId} and customer_id=#{customerId}")
    Cart exist(Cart cart);
    @Delete("delete from cart where film_id=#{filmId} and customer_id=#{customerId}")
    int del(Cart cart);
}
package com.nsu.movie2023.service;

import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.nsu.movie2023.bean.Cart;
import com.nsu.movie2023.bean.Movie;
import com.nsu.movie2023.bean.MovieDetail;
import com.nsu.movie2023.mapper.CartMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CartService {
    @Autowired
    private CartMapper cartMapper;
    public List<MovieDetail> getById(int customer_id){
        return cartMapper.getById(customer_id);
    }
    public void addToCart(Cart cart){
        Cart dbCart=cartMapper.exist(cart);
        if(dbCart==null){
            cartMapper.insert(cart);
        }
        else{
            UpdateWrapper<Cart> updateWrapper=new UpdateWrapper<>();
            updateWrapper.eq("customer_id",cart.getCustomerId());
            updateWrapper.eq("film_id",cart.getFilmId());
            cart.setCount(dbCart.getCount()+1);
            cartMapper.update(dbCart,updateWrapper);
        }
    }
    public Cart exist(Cart cart){
        return cartMapper.exist(cart);
    }
    public int del(Cart cart){
        return cartMapper.del(cart);
    }

}

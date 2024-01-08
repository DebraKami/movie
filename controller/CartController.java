package com.nsu.movie2023.controller;

import com.nsu.movie2023.bean.Cart;
import com.nsu.movie2023.bean.Customer;
import com.nsu.movie2023.bean.MovieDetail;
import com.nsu.movie2023.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class CartController {
    @Autowired
    private CartService cartService;
    @RequestMapping("/cart/{customer_id}")
    public String getById(@PathVariable("customer_id") int customer_id, Model model){
        List<MovieDetail> movieDetails=cartService.getById(customer_id);
        model.addAttribute("movieDetails",movieDetails);
        return "cartdata";
    }
    @RequestMapping("/addtocart")
    public String addToCart(int filmId, int count,HttpSession session,Model model){
        Customer customer=(Customer)session.getAttribute("customer");
        Cart cart=new Cart();
        cart.setFilmId(filmId);
        cart.setCustomerId(customer.getCustomerId());
        cart.setCount(count);
        cartService.addToCart(cart);
        List<MovieDetail> movieDetails=cartService.getById(customer.getCustomerId());
        model.addAttribute("movieDetails",movieDetails);
        return "cart";
    }
    @RequestMapping("/delcart")

    public String del(Integer filmId,HttpSession session,Model model){
        Customer customer=(Customer)session.getAttribute("customer");
        Cart cart=new Cart();
        cart.setCustomerId(customer.getCustomerId());
        cart.setFilmId(filmId);
        cartService.del(cart);
        List<MovieDetail> movieDetails=cartService.getById(customer.getCustomerId());
        model.addAttribute("movieDetails",movieDetails);
        return "cart";
    }
}

package com.nsu.movie2023.controller;

import com.nsu.movie2023.bean.Customer;
import com.nsu.movie2023.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
public class CustomerController {
    @Autowired
    private CustomerService customerService;
    @RequestMapping("/checklogin")
    public String checkLogin(Customer customer, HttpSession session){
        Customer dbCustomer=customerService.checkLogin(customer);
        if(dbCustomer!=null){
            session.setAttribute("customer",dbCustomer);
            System.out.println(session.getAttribute("customer"));
            return "redirect:/";
        }
        else
            return "login";
    }
    @RequestMapping("/tologin")
    public String tologin(){
        return "login";
    }
}

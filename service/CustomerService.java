package com.nsu.movie2023.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.nsu.movie2023.bean.Customer;
import com.nsu.movie2023.mapper.CustomerMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {
    @Autowired
    private CustomerMapper customerMapper;
    public Customer checkLogin(Customer customer){
        QueryWrapper<Customer> queryWrapper=new QueryWrapper<Customer>();
        queryWrapper.eq("password", customer.getPassword());
        queryWrapper.eq("customer_id",customer.getCustomerId());
        Customer dbCustomer=customerMapper.selectOne(queryWrapper);
        return dbCustomer;
    }
    public Customer getById(int id){
        return customerMapper.selectById(id);
    }

}

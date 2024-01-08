package com.nsu.movie2023.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.nsu.movie2023.bean.Customer;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface CustomerMapper extends BaseMapper<Customer> {
}
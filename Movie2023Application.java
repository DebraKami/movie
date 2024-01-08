package com.nsu.movie2023;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.nsu.movie2023.mapper")
public class Movie2023Application {

    public static void main(String[] args) {
        SpringApplication.run(Movie2023Application.class, args);
    }


}

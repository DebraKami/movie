package com.nsu.movie2023;
import com.nsu.movie2023.bean.Category;
import com.nsu.movie2023.mapper.CategoryMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import java.util.List;
@SpringBootTest
class Movie2023ApplicationTests {
    @Autowired
    private CategoryMapper categoryMapper;
    @Test
    void contextLoads() {
    }
    @Test
    public void testCategory(){
        List<Category> categories= categoryMapper
                .selectList(null);
        categories.forEach(System.out::println);
    }
}
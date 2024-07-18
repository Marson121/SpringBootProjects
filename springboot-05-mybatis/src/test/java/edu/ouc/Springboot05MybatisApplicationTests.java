package edu.ouc;

import edu.ouc.service.BookService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class Springboot05MybatisApplicationTests {

    @Autowired
    private BookService bookService;


    @Test
    void contextLoads() {
        System.out.println(bookService.getById(5));
    }

}

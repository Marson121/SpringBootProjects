package edu.ouc.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @author Marson
 * @date 2024/7/27
 */
@SpringBootTest
public class ServiceTest {
    @Autowired
    private BookService bookService;

    @Test
    void testGetById() {
        bookService.getById(1);
    }
}

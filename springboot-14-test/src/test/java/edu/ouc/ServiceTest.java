package edu.ouc;

import edu.ouc.pojo.Book;
import edu.ouc.service.BookService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author Marson
 * @date 2024/7/25
 */
@SpringBootTest
@Transactional
// @Rollback(false)
public class ServiceTest {

    @Autowired
    private BookService bookService;

    @Test
    void testSave() {
        Book book = new Book();
        book.setType("springboot");
        book.setName("springboot");
        book.setDescription("springboot");

        bookService.save(book);
    }
}

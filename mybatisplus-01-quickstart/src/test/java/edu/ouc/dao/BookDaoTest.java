package edu.ouc.dao;

import edu.ouc.pojo.Book;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

/**
 * @author Marson
 * @date 2024/7/29
 */
@SpringBootTest
public class BookDaoTest {

    @Autowired
    private BookDao bookDao;

    @Test
    void testSelectById() {
        bookDao.selectById(1);
    }

    @Test
    void testSelectList() {
        bookDao.selectList(null);
    }

    @Test
    void testSelectByIds() {
        List<Integer> ids = List.of(1, 2, 3, 4);
        bookDao.selectBatchIds(ids);
    }

    @Test
    void testInsert() {
        Book book = new Book();
        book.setType("test");
        book.setName("test");
        book.setDescription("test");
        bookDao.insert(book);
    }

    @Test
    void deleteById() {
        bookDao.deleteById(67);
    }

    @Test
    void update() {
        Book book = new Book();
        book.setId(79);
        book.setType("test1");
        book.setName("test1");
        book.setDescription("test1");
        bookDao.updateById(book);
    }
}

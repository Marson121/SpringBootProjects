package edu.ouc.dao;

import edu.ouc.pojo.Book;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @author Marson
 * @date 2024/7/17
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
    void testSelectAll() {
        bookDao.selectList(null);
    }

    @Test
    void testInsert() {
        Book book = new Book();
        book.setName("三体");
        book.setType("科幻");
        book.setDescription("中国科幻巨著！");
        bookDao.insert(book);
    }

    @Test
    void testUpdate() {
        Book book = new Book();
        book.setId(12);
        book.setType("科幻");
        book.setName("三体");
        book.setDescription("刘慈欣最经典的长篇科幻小说");
        bookDao.updateById(book);
    }

    @Test
    void testDelete() {
        bookDao.deleteById(12);
    }

}

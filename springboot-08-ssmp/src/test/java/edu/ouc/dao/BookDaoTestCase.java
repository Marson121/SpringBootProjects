package edu.ouc.dao;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import edu.ouc.pojo.Book;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @author Marson
 * @date 2024/7/17
 */
@SpringBootTest
public class BookDaoTestCase {

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
        book.setDescription("中国科幻");
        bookDao.insert(book);
    }

    @Test
    void testUpdate() {
        Book book = new Book();
        book.setId(51);
        book.setName("三体2黑暗森林");
        bookDao.updateById(book);
    }

    @Test
    void testDelete() {
        bookDao.deleteById(51);
    }

    @Test
    void testSelectByPage() {
        IPage page = new Page(2, 5);
        bookDao.selectPage(page, null);
    }

    @Test
    void testSelectBy1() {
        QueryWrapper<Book> qw = new QueryWrapper<>();
        qw.like("name", "Spring");
        bookDao.selectList(qw);
    }

    @Test
    void testSelectBy2() {
        String name = "Spring";
        LambdaQueryWrapper<Book> lqw = new LambdaQueryWrapper<>();
        // if(name != null) lqw.like(Book::getName,name);		                 //方式一：JAVA代码控制
        lqw.like(name != null, Book::getName, name);                // 方式二：API接口提供控制开关
        bookDao.selectList(lqw);
    }
}

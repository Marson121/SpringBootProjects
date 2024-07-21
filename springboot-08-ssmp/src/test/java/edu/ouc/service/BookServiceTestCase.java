package edu.ouc.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import edu.ouc.pojo.Book;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @author Marson
 * @date 2024/7/18
 */
@SpringBootTest
public class BookServiceTestCase {

    @Autowired
    private IBookService iBookService;

    @Test
    void testGetById() {
        System.out.println(iBookService.getById(1));
    }

    @Test
    void testGetAll() {
        System.out.println(iBookService.list());
    }

    @Test
    void testSave() {
        Book book = new Book();
        book.setType("文学");
        book.setName("活着");
        book.setDescription("余华神作");
        iBookService.save(book);
    }

    @Test
    void testUpdate() {
        Book book = new Book();
        book.setId(52);
        book.setType("文学");
        book.setName("兄弟");
        iBookService.updateById(book);
    }

    @Test
    void testDelete() {
        iBookService.removeById(52);
    }

    /**
     * MP预先定义的分页查询
     */
    @Test
    void testGetByPage() {
        IPage<Book> page = new Page<Book>(2,5);
        iBookService.page(page);
    }

    /**
     * 自定义的分页查询
     */
    @Test
    void testGetPage() {
        iBookService.getPage(1,3);
    }

    /**
     * 自定义的分页查询2（带有条件）
     */
    @Test
    void testGetPage2() {
        Book book = new Book();
        book.setName("Spring");
        iBookService.getPage(2,3, book);
    }
}

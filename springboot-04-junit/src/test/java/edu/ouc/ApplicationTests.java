package edu.ouc;

import edu.ouc.Application;
import edu.ouc.dao.BookDao;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
// @SpringBootTest(classes = Application.class)
class ApplicationTests {

    @Autowired
    private BookDao bookDao;

    @Test
    void test(){
        bookDao.save();
    }
}

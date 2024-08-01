package edu.ouc.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import edu.ouc.dao.BookDao;
import edu.ouc.pojo.Book;
import edu.ouc.service.BookService;
import org.springframework.stereotype.Service;

/**
 * @author Marson
 * @date 2024/7/31
 */
@Service
public class BookServiceImpl extends ServiceImpl<BookDao, Book> implements BookService {
}

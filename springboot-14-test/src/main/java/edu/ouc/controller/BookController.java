package edu.ouc.controller;

import edu.ouc.pojo.Book;
import edu.ouc.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author Marson
 * @date 2024/7/24
 */
@RestController
@RequestMapping("/books")
public class BookController {

    @Autowired
    private BookService bookService;

    // @GetMapping
    // public String getById() {
    //     System.out.println("getById is running...");
    //     return "success";
    // }

    @GetMapping
    public Book get() {
        System.out.println("get is running...");

        Book book = new Book();
        book.setId(1);
        book.setType("springboot");
        book.setName("springboot");
        book.setDescription("springboot");

        return book;
    }
}

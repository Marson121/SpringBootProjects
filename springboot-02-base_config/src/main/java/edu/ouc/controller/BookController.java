package edu.ouc.controller;

import org.springframework.web.bind.annotation.*;

/**
 * @author Marson
 * @date 2024/7/11
 */

@RestController
@RequestMapping("/books")
public class BookController {

    @GetMapping
    public String getAll() {
        System.out.println("book save2");
        return "book save success!";
    }

}

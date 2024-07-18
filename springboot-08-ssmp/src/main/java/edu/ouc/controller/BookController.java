package edu.ouc.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import edu.ouc.pojo.Book;
import edu.ouc.service.IBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author Marson
 * @date 2024/7/18
 */
@RestController
@RequestMapping("/books")
public class BookController {

    @Autowired
    private IBookService bookService;

    @GetMapping("/{id}")
    public Result getById(@PathVariable Integer id) {
        return new Result(true, bookService.getById(id));
    }

    @GetMapping
    public Result getAll() {
        return new Result(true, bookService.list());
    }

    @PostMapping
    public Result save(@RequestBody Book book) {
        return new Result(bookService.save(book));
    }

    @PutMapping
    public Result update(@RequestBody Book book) {
        return new Result(bookService.updateById(book));
    }

    @DeleteMapping("/{id}")
    public Result delete(@PathVariable Integer id) {
        return new Result(bookService.removeById(id));
    }

    @GetMapping("/{currentPage}/{pageSize}")
    public Result getByPage(@PathVariable int currentPage, @PathVariable int pageSize) {
        return new Result(true, bookService.getPage(currentPage, pageSize));
    }

}

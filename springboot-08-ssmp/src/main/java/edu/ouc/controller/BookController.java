package edu.ouc.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import edu.ouc.controller.utils.Result;
import edu.ouc.pojo.Book;
import edu.ouc.service.IBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
    public Result save(@RequestBody Book book) throws Exception {
        if (book.getName().equals("123")) throw new Exception();
        boolean flag = bookService.save(book);
        return new Result(flag, flag ? "添加成功！" : "添加失败！");
    }

    @PutMapping
    public Result update(@RequestBody Book book) {
        boolean flag = bookService.updateById(book);
        return new Result(flag, flag ? "修改成功！" : "修改失败！");
    }

    @DeleteMapping("/{id}")
    public Result delete(@PathVariable Integer id) {
        boolean flag = bookService.removeById(id);
        return new Result(flag, flag ? "删除成功！" : "数据同步出错！已重新同步数据！");
    }

    // @GetMapping("/{currentPage}/{pageSize}")
    // public Result getByPage(@PathVariable int currentPage, @PathVariable int pageSize) {
    //     IPage<Book> page = bookService.getPage(currentPage, pageSize);
    //     // 如果当前页码大于了最大页码值，重新执行查询，跳转到第一页（防止最后一页只有一条数据，删除后当前页码会大于最大页码值）
    //     if (currentPage > page.getPages()) {
    //         page = bookService.getPage(1, pageSize);
    //     }
    //     return new Result(true, page);
    // }

    @GetMapping("/{currentPage}/{pageSize}")
    public Result getByPage(@PathVariable int currentPage, @PathVariable int pageSize, Book book) {
        IPage<Book> page = bookService.getPage(currentPage, pageSize, book);
        // 如果当前页码大于了最大页码值，重新执行查询，跳转到第一页（防止最后一页只有一条数据，删除后当前页码会大于最大页码值）
        if (currentPage > page.getPages()) {
            page = bookService.getPage(1, pageSize);
        }
        return new Result(true, page);
    }

}

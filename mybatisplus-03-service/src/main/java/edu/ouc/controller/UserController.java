package edu.ouc.controller;

import edu.ouc.pojo.User;
import edu.ouc.pojo.query.UserQuery;
import edu.ouc.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author Marson
 * @date 2024/7/31
 */
@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping
    public String save(@RequestBody User user) {
        userService.save(user);
        return "success";
    }

    @GetMapping("/{id}")
    public User getById(@PathVariable Integer id) {
        return userService.getById(id);
    }

    @GetMapping
    public List<User> getAll() {
        return userService.list();
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable Integer id) {
        userService.removeById(id);
        return "success";
    }

    @PutMapping
    public String update(@RequestBody User user) {
        userService.updateById(user);
        return "success";
    }

    /**
     * 根据id扣除该用户余额指定金额
     * @param id
     * @param money
     * @return
     */
    @PutMapping("/{id}/deduction/{money}")
    public String deductBalance(@PathVariable Integer id, @PathVariable Integer money){
        userService.deductBalance(id, money);
        return "success";
    }

    /**
     * 根据id扣除该用户余额指定金额
     * @param id
     * @param money
     * @return
     */
    @PutMapping("/{id}/deduction2/{money}")
    public String deductBalance2(@PathVariable Integer id, @PathVariable Integer money){
        userService.deductBalance2(id, money);
        return "success";
    }

    @GetMapping("/list")
    List<User> getByCondition(UserQuery userQuery) {
        // UserQuery实体类用于方便接受页面参数
        return userService.getByCondition(userQuery);
    }


}

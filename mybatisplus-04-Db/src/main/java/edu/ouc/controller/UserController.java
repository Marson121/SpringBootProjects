package edu.ouc.controller;

import edu.ouc.pojo.Address;
import edu.ouc.pojo.vo.UserVO;
import edu.ouc.service.AddressService;
import edu.ouc.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author Marson
 * @date 2024/8/1
 */
@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("/{id}")
    public UserVO getUserById(@PathVariable Integer id) {
        return userService.getUserAndAddressById(id);
    }

}

package edu.ouc.service;

import edu.ouc.pojo.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;

/**
 * @author Marson
 * @date 2024/7/31
 */
@SpringBootTest
public class UserServiceTest {
    @Autowired
    private UserService userService;

    @Test
    void testSave() {
        User user = new User();
        user.setUsername("aaa");
        user.setPassword("aaa");
        user.setPhone("13112345678");
        user.setInfo("{\"age\": 20, \"intro\": \"装杯青年\", \"gender\": \"male\"}");
        user.setStatus(1);
        user.setBalance(100);

        userService.save(user);
    }


    @Test
    void testSaveOneByOne() {
        long start = System.currentTimeMillis();
        for (int i = 0; i < 100000; i++) {
            userService.save(buildUser(i));
        }
        long end = System.currentTimeMillis();
        System.out.println("耗时：" + (end - start));
    }

    @Test
    void testSaveBatch() {
        ArrayList<User> users = new ArrayList<>(1000);
        long start = System.currentTimeMillis();
        for (int i = 1; i <= 100000; i++) {
            users.add(buildUser(i));
            // 每1000条批量插入一次
            if (i % 1000 == 0) {
                userService.saveBatch(users);
                users.clear();
            }
        }
        long end = System.currentTimeMillis();
        System.out.println("耗时：" + (end - start));
    }

    public User buildUser(int i) {
        User user = new User();
        user.setUsername("user_" + i);
        user.setPassword("123");
        user.setPhone("110" + i);
        user.setStatus(1);
        user.setInfo("\"{\\\"age\\\": 24, \\\"intro\\\": \\\"英文老师\\\", \\\"gender\\\": \\\"female\\\"}\"");
        user.setBalance(1000);
        return user;
    }
}

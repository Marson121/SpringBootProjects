package edu.ouc.service;

import com.baomidou.mybatisplus.extension.toolkit.Db;
import edu.ouc.pojo.User;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

/**
 * @author Marson
 * @date 2024/8/1
 */
@SpringBootTest
public class UserServiceTest {

    @Test
    void testDbGetById() {
        User user = Db.getById(1, User.class);
        System.out.println(user);
    }

    @Test
    void testDbGetAll() {
        List<User> list = Db.list(User.class);
        System.out.println(list);
    }

    /**
     * 查询名字中带有o且余额大于100的用户信息
     */
    @Test
    void testDbGetByCondition() {
        List<User> list = Db.lambdaQuery(User.class)
                .like(User::getUsername, "o")
                .ge(User::getBalance, 100)
                .list();

        System.out.println(list);
    }

    @Test
    void testDbSave() {
        User user = new User();
        user.setUsername("giao");
        user.setPassword("123");
        user.setPhone("110");
        user.setInfo("一给我里giaogiao!");
        user.setStatus(1);
        user.setBalance(500);

        Db.save(user);
    }

    /**
     * 根据id修改用户的金额为指定值
     */
    @Test
    void testDbUpdate() {
        Db.lambdaUpdate(User.class)
                .set(User::getBalance, 2000)
                .eq(User::getId, 1)
                .update();
    }

    @Test
    void testDbDeleteById() {
        Db.removeById(200011, User.class);
    }
}

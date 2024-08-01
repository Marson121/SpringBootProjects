package edu.ouc.dao;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import edu.ouc.pojo.Address;
import edu.ouc.pojo.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

/**
 * @author Marson
 * @date 2024/7/30
 */
@SpringBootTest
public class UserDaoTest {

    @Autowired
    private UserDao userDao;

    /**
     * 查询出名字中带o的，存款大于等于1000元的人的id,username, info, balance
     */
    @Test
    void testQueryWrapper() {
        QueryWrapper<User> wrapper = new QueryWrapper<User>();
        wrapper.select("id", "username","info", "balance");
        wrapper.like("username", "o");
        wrapper.ge("balance", 1000);

        List<User> users = userDao.selectList(wrapper);

        System.out.println(users);
    }

    /**
     * 查询名字以e结尾，存款在[0,1000]之间的用户的id,username,balance
     */
    @Test
    void testQueryWrapper2() {
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        wrapper.select("id", "username", "balance");
        wrapper.between("balance", "0", "1000");
        wrapper.likeLeft("username", "e");          // %e

        List<User> users = userDao.selectList(wrapper);

        System.out.println(users);
    }

    /**
     * 更新用户名为jack的用户的余额为2000
     */
    @Test
    void testUpdateWrapper() {
        UpdateWrapper<User> wrapper = new UpdateWrapper<User>();
        wrapper.eq("username", "jack");
        wrapper.set("balance", 2000);

        userDao.update(null, wrapper);
    }

    /**
     * 更新id为1,2,4的用户的余额，扣200
     */
    @Test
    void testUpdateWrapper2() {
        List<Long> ids = List.of(1L, 2L, 4L);

        UpdateWrapper<User> wrapper = new UpdateWrapper<User>();
        wrapper.setSql("balance = balance - 200");
        wrapper.in("id", ids);

        userDao.update(null, wrapper);
    }

    /**
     * 查询出名字中带o的，存款大于等于1000元的人的id,username, info, balance
     */
    @Test
    void testLambdaQueryWrapper() {
        LambdaQueryWrapper<User> wrapper = new LambdaQueryWrapper<>();
        wrapper.select(User::getId, User::getUsername, User::getInfo, User::getBalance);
        wrapper.like(User::getUsername, "o");
        wrapper.ge(User::getBalance, "1000");

        List<User> users = userDao.selectList(wrapper);

        System.out.println(users);
    }

    /**
     * 查询名字以e结尾，存款在[0,1000]之间的用户的id,username,balance
     */
    @Test
    void testLambdaQueryWrapper2() {
        LambdaQueryWrapper<User> wrapper = new LambdaQueryWrapper<>();
        wrapper.select(User::getId, User::getUsername, User::getBalance);
        wrapper.between(User::getBalance, 0, 1000);
        wrapper.likeLeft(User::getUsername, "e");

        List<User> users = userDao.selectList(wrapper);

        System.out.println(users);
    }

    /**
     * 更新用户名为jack的用户的余额为2000
     */
    @Test
    void testLambdaUpdateWrapper() {
        LambdaUpdateWrapper<User> wrapper = new LambdaUpdateWrapper<>();
        wrapper.eq(User::getUsername, "jack");
        wrapper.set(User::getBalance, "2000");

        userDao.update(null, wrapper);
    }

    /**
     * 更新id为1,2,4的用户的余额，扣200
     */
    @Test
    void testLambdaUpdateWrapper2() {
        List<Long> ids = List.of(1L, 2L, 4L);
        LambdaUpdateWrapper<User> wrapper = new LambdaUpdateWrapper<>();
        wrapper.in(User::getId, ids);
        wrapper.setSql("balance = balance - 200");

        userDao.update(null, wrapper);
    }

    /**
     * 更新id为1,2,4的用户的余额，扣200
     * 自定义sql，复杂部分交给自定义方法，where条件交给mp
     */
    @Test
    void testCustomWrapper() {
        List<Long> ids = List.of(1L, 2L, 4L);
        int money = 200;

        LambdaUpdateWrapper<User> wrapper = new LambdaUpdateWrapper<>();
        wrapper.in(User::getId, ids);

        userDao.updateByIds(wrapper, money);

    }

    /**
     * 查询所有收货地址在日照的并且用户id在1、2、4之中的用户
     */
    @Test
    void testCustomJoinWrapper() {
        List<Long> ids = List.of(1L, 2L, 4L);

        QueryWrapper<User> wrapper = new QueryWrapper<User>();
        wrapper.in("u.id", ids);
        wrapper.like("a.address", "日照");

        List<User> users = userDao.selectJoin(wrapper);

        System.out.println(users);

    }
}

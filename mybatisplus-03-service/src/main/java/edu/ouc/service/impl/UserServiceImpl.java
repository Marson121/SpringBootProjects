package edu.ouc.service.impl;

import com.alibaba.druid.sql.visitor.functions.Nil;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import edu.ouc.dao.UserDao;
import edu.ouc.pojo.User;
import edu.ouc.pojo.query.UserQuery;
import edu.ouc.service.UserService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author Marson
 * @date 2024/7/31
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserDao, User> implements UserService {
    /**
     * 据id查询用户，并扣减指定余额
     * @param id
     * @param money
     */
    @Override
    public void deductBalance(Integer id, Integer money) {
        // 1.根据id查询用户
        User user = getById(id);
        // 2.判断用户状态
        if (user == null || user.getStatus() == 2) {
            throw new RuntimeException("该用户被冻结！");
        }
        // 3.判断用户余额
        if (user.getBalance() < money) {
            throw new RuntimeException("该用户余额不足！");
        }
        // 4.扣减余额
        baseMapper.decuctBalanceById(id, money);
    }

    /**
     * 根据id查询用户，并扣减指定余额
     * 增强版
     * 扣减余额后如果余额为0 则把状态设置为冻结
     * 使用lambdaUpdate操作
     *
     * @param id
     * @param money
     */
    @Override
    @Transactional
    public void deductBalance2(Integer id, Integer money) {
        // 1.根据id查询用户
        User user = getById(id);
        // 2.判断用户状态
        if (user == null || user.getStatus() == 2) {
            throw new RuntimeException("该用户被冻结！");
        }
        // 3.判断用户余额
        if (user.getBalance() < money) {
            throw new RuntimeException("该用户余额不足！");
        }
        // 4.扣减余额
        // 根据id查询用户，设置余额（与之前不同，之前是拼sql，这里直接计算余额），根据余额设置状态，执行更新操作
        int remainBalance = user.getBalance() - money;
        lambdaUpdate()
                .eq(User::getId, id)
                .set(User::getBalance, remainBalance)
                .set(remainBalance == 0, User::getStatus, 2)
                .update();
    }


    /**
     * 模拟管理员在页面勾选条件进行查询，条件可能有可能没有
     *
     * @param userQuery
     * @return
     */
    @Override
    public List<User> getByCondition(UserQuery userQuery) {
        // 读取从页面传递的参数
        String name = userQuery.getName();
        Integer status = userQuery.getStatus();
        Integer maxBalance = userQuery.getMaxBalance();
        Integer minBalance = userQuery.getMinBalance();

        // 根据参数查询
        return lambdaQuery()
                .like(name != null, User::getUsername, name)
                .eq(status != null, User::getStatus, status)
                .ge(minBalance != null, User::getBalance, minBalance)
                .le(maxBalance != null, User::getBalance, maxBalance)
                .list();
    }
}

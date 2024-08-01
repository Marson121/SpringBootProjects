package edu.ouc.service;

import com.baomidou.mybatisplus.extension.service.IService;
import edu.ouc.pojo.User;
import edu.ouc.pojo.query.UserQuery;

import java.util.List;

/**
 * @author Marson
 * @date 2024/7/31
 */
public interface UserService extends IService<User> {
    // 复杂业务自己实现

    void deductBalance(Integer id, Integer money);

    void deductBalance2(Integer id, Integer money);

    List<User> getByCondition(UserQuery userQuery);
}

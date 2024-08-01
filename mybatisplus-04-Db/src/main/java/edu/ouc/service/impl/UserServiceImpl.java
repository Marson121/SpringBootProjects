package edu.ouc.service.impl;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.collection.CollUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.baomidou.mybatisplus.extension.toolkit.Db;
import edu.ouc.dao.UserDao;
import edu.ouc.pojo.Address;
import edu.ouc.pojo.User;
import edu.ouc.pojo.vo.UserVO;
import edu.ouc.service.UserService;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author Marson
 * @date 2024/7/31
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserDao, User> implements UserService {
    /**
     * UserVO对象中除了封装一般信息还额外封装了地址列表信息，列表里每个值都是AddressVO对象
     * 根据id查询用户，并根据id去Address表查询该用户的地址
     * 最后封装为UserVO对象返回
     *
     * @param id
     * @return
     */
    @Override
    public UserVO getUserAndAddressById(Integer id) {
        // 1.查询用户
        User user = getById(id);
        if (user == null || user.getStatus() == 2) {
            throw new RuntimeException("用户状态异常！");
        }

        // 2.根据用户id查询收货地址（可能有多个）
        // 需要AddressService，但是通过静态方法，避免注入AddressService
        List<Address> addresses = Db.lambdaQuery(Address.class)
                .eq(Address::getUserId, id)
                .list();

        // 3.处理vo
        // 3.1 po转vo
        UserVO userVO = BeanUtil.copyProperties(user, UserVO.class);
        // 3.2 向vo set地址
        userVO.setAddress(BeanUtil.copyToList(addresses, Address.class));
        return userVO;
    }
}

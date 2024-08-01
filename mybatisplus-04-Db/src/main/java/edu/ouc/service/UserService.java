package edu.ouc.service;

import com.baomidou.mybatisplus.extension.service.IService;
import edu.ouc.pojo.User;
import edu.ouc.pojo.vo.UserVO;

import java.util.List;


/**
 * @author Marson
 * @date 2024/7/31
 */
public interface UserService extends IService<User> {
    UserVO getUserAndAddressById(Integer id);
}

package edu.ouc.dao;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import edu.ouc.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

/**
 * @author Marson
 * @date 2024/7/29
 */
@Mapper
public interface UserDao extends BaseMapper<User> {
    @Update("update user set balance = balance - #{money} where id = #{id}")
    void decuctBalanceById(@Param("id") Integer id, @Param("money") Integer money);
}

package edu.ouc.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import edu.ouc.pojo.Address;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author Marson
 * @date 2024/8/1
 */
@Mapper
public interface AddressDao extends BaseMapper<Address> {
}

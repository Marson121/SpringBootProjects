package edu.ouc.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import edu.ouc.pojo.Book;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author Marson
 * @date 2024/7/25
 */

@Mapper
public interface BookDao extends BaseMapper<Book> {
}

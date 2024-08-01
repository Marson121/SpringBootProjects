package edu.ouc.service;

import edu.ouc.pojo.Book;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * @author Marson
 * @date 2024/7/27
 */
@SpringBootTest
public class ServiceTest {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Test
    void testGetAll() {
        String sql = "select * from tbl_book";

        RowMapper<Book> rowMapper = new RowMapper<Book>() {
            @Override
            public Book mapRow(ResultSet resultSet, int i) throws SQLException {
                Book temp = new Book();
                temp.setId(resultSet.getInt("id"));
                temp.setType(resultSet.getString("type"));
                temp.setName(resultSet.getString("name"));
                temp.setDescription(resultSet.getString("description"));
                return temp;
            }
        };

        List<Book> list = jdbcTemplate.query(sql, rowMapper);
        System.out.println(list);
    }

}

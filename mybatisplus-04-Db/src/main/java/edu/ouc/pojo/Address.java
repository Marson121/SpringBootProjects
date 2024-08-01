package edu.ouc.pojo;


import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * @author Marson
 * @date 2024/7/31
 */
@Data
public class Address {
    private Integer id;
    private Integer userId;
    private String address;
}

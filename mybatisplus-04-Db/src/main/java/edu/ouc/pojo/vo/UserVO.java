package edu.ouc.pojo.vo;


import edu.ouc.pojo.Address;
import lombok.Data;

import java.util.List;

/**
 * @author Marson
 * @date 2024/8/1
 */
@Data
public class UserVO {
    private Integer id;
    private String username;
    private String phone;
    private Integer status;
    private Integer balance;
    private List<Address> address;
}

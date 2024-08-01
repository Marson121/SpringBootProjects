package edu.ouc.pojo;


import lombok.Data;

/**
 * @author Marson
 * @date 2024/7/29
 */
@Data
public class User {
    private Integer id;
    private String username;
    private String password;
    private String phone;
    private String info;
    private Integer status;
    private Integer balance;
}

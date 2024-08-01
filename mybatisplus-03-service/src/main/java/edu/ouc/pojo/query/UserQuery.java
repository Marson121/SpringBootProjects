package edu.ouc.pojo.query;

import lombok.Data;

/**
 * @author Marson
 * @date 2024/7/31
 */
@Data
public class UserQuery {
    private String name;
    private Integer status;
    private Integer minBalance;
    private Integer maxBalance;
}

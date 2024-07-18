package edu.ouc.controller;

import lombok.Data;

/**
 * @author Marson
 * @date 2024/7/18
 */
@Data
public class Result {
    private Boolean flag;
    private Object data;

    public Result() {
    }

    public Result(Boolean flag) {
        this.flag = flag;
    }

    public Result(Boolean flag, Object data) {
        this.flag = flag;
        this.data = data;
    }
}

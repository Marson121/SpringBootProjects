package edu.ouc.controller.utils;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @author Marson
 * @date 2024/7/19
 */
@RestControllerAdvice
public class ProjectExceptionAdvice {
    @ExceptionHandler
    public Result doException(Exception exception){
        exception.printStackTrace();
        return new Result(false, null, "系统故障，请稍后重试！");
    }
}

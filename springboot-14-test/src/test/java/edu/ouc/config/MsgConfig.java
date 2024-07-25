package edu.ouc.config;

import org.springframework.context.annotation.Bean;

/**
 * @author Marson
 * @date 2024/7/24
 */
public class MsgConfig {

    @Bean
    public String msg() {
        return "string bean test";
    }
}

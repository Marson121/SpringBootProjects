package edu.ouc.pojo;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @author Marson
 * @date 2024/7/25
 */
@Data
@ConfigurationProperties(prefix = "testcase.people")
public class People {

    private Integer id;
    private String type;
    private Integer score;
    private String uuid;
    private long time;
}

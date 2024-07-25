package edu.ouc.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @author Marson
 * @date 2024/7/24
 */
@Data
@Component
@ConfigurationProperties(prefix = "servers")            // @ConfigurationProperties加在类上
public class ServerConfig {
    private String ipAddress;
    private int port;
    private long timeout;
}

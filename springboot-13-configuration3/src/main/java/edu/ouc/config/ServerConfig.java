package edu.ouc.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @author Marson
 * @date 2024/7/24
 */
@Data
@ConfigurationProperties(prefix = "servers")     // 允许
// @ConfigurationProperties(prefix = "ser-vers")    // 允许
// @ConfigurationProperties(prefix = "ser_vers")    // 不允许
// @ConfigurationProperties(prefix = "Servers")     // 不允许
public class ServerConfig {
    private String ipAddress;
    private int port;
    private long timeout;
}

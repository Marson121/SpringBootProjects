package edu.ouc;

import edu.ouc.config.ServerConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
@EnableConfigurationProperties(ServerConfig.class)
public class Springboot13Configutation4Application {

    public static void main(String[] args) {
        ConfigurableApplicationContext ctx = SpringApplication.run(Springboot13Configutation4Application.class, args);
        ServerConfig serverConfig = ctx.getBean(ServerConfig.class);
        System.out.println(serverConfig);
    }

}

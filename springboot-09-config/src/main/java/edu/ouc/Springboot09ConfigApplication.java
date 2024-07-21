package edu.ouc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Springboot09ConfigApplication {

    public static void main(String[] args) {
        String[] arg = new String[1];
        arg[0] = "--server.port=90";
        SpringApplication.run(Springboot09ConfigApplication.class, arg);
    }
}

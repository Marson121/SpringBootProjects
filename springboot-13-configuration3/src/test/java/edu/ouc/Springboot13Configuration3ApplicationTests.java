package edu.ouc;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class Springboot13Configuration3ApplicationTests {


    @Value("${servers.ipAddress}")
    private String ipAddress;

    @Test
    void contextLoads() {
        System.out.println(ipAddress);
    }

}

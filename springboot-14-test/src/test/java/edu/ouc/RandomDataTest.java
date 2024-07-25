package edu.ouc;

import edu.ouc.pojo.People;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @author Marson
 * @date 2024/7/25
 */
@SpringBootTest
@EnableConfigurationProperties(People.class)
public class RandomDataTest {

    @Autowired
    private People people;

    @Test
    void test() {
        System.out.println(people);
    }
}

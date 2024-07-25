package edu.ouc;

import edu.ouc.config.MsgConfig;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;

/**
 * @author Marson
 * @date 2024/7/24
 */
@SpringBootTest
@Import({MsgConfig.class})      // 加载第三方bean的配置类
public class ConfigurationTest {
    @Autowired
    private String msg;

    @Test
    void test() {
        System.out.println(msg);
    }
}

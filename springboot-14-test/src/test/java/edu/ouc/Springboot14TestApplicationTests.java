package edu.ouc;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;

// properties属性可以给当前测试类添加临时的属性配置
@SpringBootTest(properties = {"env.maxMemory=20GB"})
// args属性可以给当前测试类添加命令行临时参数
// @SpringBootTest(args = {"--env.maxMemory=25GB"})
// 一般不会这么用,如果同时写,args命令行参数的优先级会更高
// @SpringBootTest(args = {"--env.maxMemory=25GB"}, properties = {"env.maxMemory=20GB"})
class Springboot14TestApplicationTests {

    @Value("${env.maxMemory}")
    private String maxMemory;

    @Test
    void contextLoads() {
        System.out.println(maxMemory);
    }

}

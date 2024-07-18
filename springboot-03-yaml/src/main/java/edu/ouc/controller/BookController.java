package edu.ouc.controller;

import edu.ouc.MyDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.*;

/**
 * @author Marson
 * @date 2024/7/11
 */

@RestController
@RequestMapping("/books")
public class BookController {

    @Value("${country}")
    private String country;

    @Value("${province}")
    private String province;

    @Value("${city}")
    private String city;

    // 不能直接注入数组
    @Value("${subject[0]}")
    private String subject;

    @Value("${server.port}")
    private int port;

    @Value("${users[1].name}")
    private String username;

    @Autowired
    private Environment env;

    @Autowired
    private MyDataSource myDataSource;

    @Value("${center.logDir}")
    private String dir;

    @GetMapping
    public String getAll() {
        System.out.println("book save");
        System.out.println("-----------------------");
        System.out.println("country ==> " + country);
        System.out.println("province ==> " + province);
        System.out.println("city ==> " + city);
        System.out.println("subject[0] ==> " + subject);
        System.out.println("port ==> " + port);
        System.out.println("username ==> " + username);
        System.out.println("-----------------------");
        System.out.println("port = " + env.getProperty("server.port"));
        System.out.println("province = " + env.getProperty("province"));
        System.out.println("subject = " + env.getProperty("subject[1]"));
        System.out.println("age = " + env.getProperty("users[1].age"));
        System.out.println("-----------------------");
        System.out.println("datasource = " + myDataSource);
        System.out.println("-----------------------");
        System.out.println("logDir: " + dir);
        return "book save success!";
    }

}

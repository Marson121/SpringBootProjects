package edu.ouc;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.ContentResultMatchers;
import org.springframework.test.web.servlet.result.HeaderResultMatchers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.result.StatusResultMatchers;

/**
 * @author Marson
 * @date 2024/7/24
 */
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
// 开启MVC虚拟调用
@AutoConfigureMockMvc
public class WebTest {

    @Autowired
    MockMvc mvc;

    @Test
    void testPort(){

    }

    @Test
    void testWeb() throws Exception {
        // 创建虚拟请求
        MockHttpServletRequestBuilder builder = MockMvcRequestBuilders.get("/books");
        // 执行对应的请求
        mvc.perform(builder);
    }

    @Test
    void testStatus() throws Exception {
        MockHttpServletRequestBuilder builder = MockMvcRequestBuilders.get("/books");
        ResultActions action = mvc.perform(builder);

        // 设定预期值与真实值进行比较,成功则测试通过,否则测试失败
        // 定义本次调用的预期值
        StatusResultMatchers status = MockMvcResultMatchers.status();
        // 预计本次调用成功,状态码=200
        ResultMatcher ok = status.isOk();

        // 添加预计值到本次调用过程进行匹配
        action.andExpect(ok);

    }

    @Test
    void testBody() throws Exception {
        MockHttpServletRequestBuilder builder = MockMvcRequestBuilders.get("/books");
        ResultActions action = mvc.perform(builder);

        ContentResultMatchers content = MockMvcResultMatchers.content();
        ResultMatcher result = content.string("success");

        action.andExpect(result);

    }

    @Test
    void testJson() throws Exception {
        MockHttpServletRequestBuilder builder = MockMvcRequestBuilders.get("/books");
        ResultActions action = mvc.perform(builder);

        ContentResultMatchers content = MockMvcResultMatchers.content();
        ResultMatcher result = content.json("{\n" +
                "  \"id\": 1,\n" +
                "  \"name\": \"springboot\",\n" +
                "  \"type\": \"springboot\",\n" +
                "  \"description\": \"springboot\"\n" +
                "}");
        action.andExpect(result);
    }

    @Test
    void testContentType() throws Exception {
        MockHttpServletRequestBuilder builder = MockMvcRequestBuilders.get("/books");
        ResultActions action = mvc.perform(builder);

        HeaderResultMatchers header = MockMvcResultMatchers.header();
        ResultMatcher contentType = header.string("Content-Type", "application/json");

        action.andExpect(contentType);
    }

    /**
     * 实际测试中使用如下格式，测试多个条件
     * @throws Exception
     */
    @Test
    void testGet() throws Exception {
        MockHttpServletRequestBuilder builder = MockMvcRequestBuilders.get("/books");
        ResultActions action = mvc.perform(builder);

        StatusResultMatchers status = MockMvcResultMatchers.status();
        ResultMatcher ok = status.isOk();
        action.andExpect(ok);

        HeaderResultMatchers header = MockMvcResultMatchers.header();
        ResultMatcher contentType = header.string("Content-Type", "application/json");
        action.andExpect(contentType);

        ContentResultMatchers content = MockMvcResultMatchers.content();
        ResultMatcher result = content.json("{\n" +
                "  \"id\": 1,\n" +
                "  \"name\": \"springboot\",\n" +
                "  \"type\": \"springboot\",\n" +
                "  \"description\": \"springboot\"\n" +
                "}");
        action.andExpect(result);
    }
}

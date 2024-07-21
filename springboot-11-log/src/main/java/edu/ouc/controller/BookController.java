package edu.ouc.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


/**
 * @author Marson
 * @date 2024/7/11
 */

@Slf4j
@RestController
@RequestMapping("/books")
public class BookController {
    @GetMapping
    public String getAll() {
        System.out.println("book save");

        log.debug("debug...");
        log.info("info...");
        log.warn("warn...");
        log.error("error...");

        return "book save success!";
    }

}

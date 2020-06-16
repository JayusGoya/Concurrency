package com.jayus.Concurrency;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: wangjiajun
 * @date: 2020-06-12 11:35
 */
@RestController
@Slf4j
public class TestController {
    @RequestMapping("/test")
        public String test(){
            return "test";
        }
}

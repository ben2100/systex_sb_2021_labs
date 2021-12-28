package com.systex.demo1;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {
    @GetMapping(value = "/ping", name = "default ping pong rest controller")
    public String ping() {
        return "pong";
    }
}

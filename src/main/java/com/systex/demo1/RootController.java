package com.systex.demo1;

import org.springframework.beans.factory.annotation.Autowired;
import  org.springframework.stereotype.Controller;
import  org.springframework.web.bind.annotation.GetMapping;
import  org.springframework.web.bind.annotation.Mapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class RootController {
    @Autowired
    private GreetingService service;
    @GetMapping("/")
    public String myHome() {
        return "home";
    }
    @RequestMapping("/greeting")
    public @ResponseBody
    String greeting() {
        return service.greet();
    }
}




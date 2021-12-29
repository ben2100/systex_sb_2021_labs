package com.systex.demo1;

import org.springframework.stereotype.Service;

@Service
public class GreetingService {
    public String greet() {
        return "!!!hello my service, send someting....";
    }
}
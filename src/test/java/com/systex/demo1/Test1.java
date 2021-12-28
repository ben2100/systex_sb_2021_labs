package com.systex.demo1;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class Test1 {
    @Autowired
    private RootController rootController;
    @Test
    void contextLoad() {
        assertThat(rootController).isNotNull();
    }
}
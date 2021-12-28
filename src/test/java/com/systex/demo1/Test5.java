package com.systex.demo1;

import org.junit.jupiter.api.*;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

public class Test5 {
    private static Validator validator;
    @BeforeAll
    public static void setupValidationInstance() {
        System.out.println("one term startup");
        validator = Validation.buildDefaultValidatorFactory().getValidator();
    }
    @BeforeEach
    public void prepare() {
        System.out.println("this will be executed before each run");
    }
    @AfterEach
    public void cleanup() {
        System.out.println("this will be executed after each run");
    }
    @AfterAll
    public static void oneTermCleanUp() {
        System.out.println("final cleanup");
    }
    @Test
    public void test51() {
        NormalUser2 user = new NormalUser2("Mark");
        Set<ConstraintViolation<NormalUser2>>violations =  validator.validate(user);
        assertThat(violations.size()).isEqualTo(0);
    }
    @Test
    public void test52() {
        NormalUser2 user = new NormalUser2("");
        Set<ConstraintViolation<NormalUser2>>violations =  validator.validate(user);
        assertThat(violations.size()).isEqualTo(1);
    }
    @Test
    public void test53() {
        NormalUser2 user = new NormalUser2(null);
        Set<ConstraintViolation<NormalUser2>>violations =  validator.validate(user);
        assertThat(violations.size()).isEqualTo(1);

    }

}
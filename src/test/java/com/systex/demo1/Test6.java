package com.systex.demo1;

import org.junit.jupiter.api.*;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

public class Test6 {
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
    public void test61() {
        NormalUser3 user = new NormalUser3("Mark");
        Set<ConstraintViolation<NormalUser3>>violations =  validator.validate(user);
        assertThat(violations.size()).isEqualTo(0);
    }
    @Test
    public void test62() {
        NormalUser3 user = new NormalUser3("");
        Set<ConstraintViolation<NormalUser3>>violations =  validator.validate(user);
        assertThat(violations.size()).isEqualTo(1);
    }
    @Test
    public void test63() {
        NormalUser3 user = new NormalUser3(null);
        Set<ConstraintViolation<NormalUser3>>violations =  validator.validate(user);
        assertThat(violations.size()).isEqualTo(1);
    }
    @Test
    public void test64() {
        NormalUser3 user = new NormalUser3("                     ");
        Set<ConstraintViolation<NormalUser3>>violations =  validator.validate(user);
        assertThat(violations.size()).isEqualTo(1);
    }

}
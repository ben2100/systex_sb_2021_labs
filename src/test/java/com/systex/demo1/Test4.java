package com.systex.demo1;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

@Slf4j
public class Test4 {
    private static Validator validator;
    private static final Logger LOGGER = LoggerFactory.getLogger(Test4.class.getSimpleName());
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
    public void test41() {
        NormalUser1 user = new NormalUser1("Mark");
        Set<ConstraintViolation<NormalUser1>>violations =  validator.validate(user);
        assertThat(violations.size()).isEqualTo(0);
    }
    @Test
    public void test42() {
        NormalUser1 user = new NormalUser1("");
        Set<ConstraintViolation<NormalUser1>>violations =  validator.validate(user);
        assertThat(violations.size()).isEqualTo(0);
    }
    @Test
    public void test43() {
        NormalUser1 user = new NormalUser1(null);
        Set<ConstraintViolation<NormalUser1>> violations = validator.validate(user);
        for (ConstraintViolation<NormalUser1> violation : violations) {
            LOGGER.error("the error message is:{},{}", violation.getMessage(), 500);
            log.error("[from @slf4j] is:{}",violation.getMessage());

        }
        assertThat(violations.size()).isEqualTo(1);

    }


}
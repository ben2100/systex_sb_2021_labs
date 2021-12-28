package com.systex.demo1;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import javax.validation.Valid;

@Slf4j
@Controller
public class CourseController implements WebMvcConfigurer {

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        WebMvcConfigurer.super.addViewControllers(registry);
        registry.addViewController("/results").setViewName("result");
    }

    @GetMapping("/course")
    public String showForm(CourseForm xyzForm) {
        return "courseForm";
    }



    @PostMapping("/course")
    public String showResult(@Valid CourseForm form, BindingResult bindingResult) {
        log.info("get a course with id:{},name:{},duration:{}",
                form.getCourseId(), form.getCourseName(), form.getDuration());
        log.info("print course: {}",form);
        if (bindingResult.hasErrors()) {
            log.error("something error happen: {}",bindingResult);
            return "courseForm";
        }
        return "redirect:/results";
    }
}

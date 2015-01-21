package com.test.demo;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HelloController {
    @RequestMapping("/hello")
    public ModelAndView hello(String name, ModelAndView modelAndView) {
        if (name != null) {
            modelAndView.addObject("name", name);
            modelAndView.getModel().put("name", name);
        }
        modelAndView.setViewName("hello");
        return modelAndView;
    }
}

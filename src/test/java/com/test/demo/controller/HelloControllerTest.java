package com.test.demo.controller;

import com.test.demo.controller.HelloController;
import com.test.demo.service.HelloService;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.test.util.ReflectionTestUtils;
import org.springframework.ui.ModelMap;
import org.springframework.web.servlet.ModelAndView;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class HelloControllerTest {

    HelloController controller;
    HelloService service =  new HelloService(){
        @Override
        public String hello(String name) {
            return "hello";
        }
    };

    @Before
    public void setUp() throws Exception {
        controller = new HelloController();
    }

    @After
    public void tearDown() throws Exception {

    }

    @Test
    public void testHello() throws Exception {
        ReflectionTestUtils.setField(controller, "helloService", service);
        String rs = controller.hello("test", new ModelMap());

        assertThat(rs, is("hello"));
    }
}
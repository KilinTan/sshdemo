package com.test.demo;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.web.servlet.ModelAndView;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class HelloControllerTest {

    HelloController controller;

    @Before
    public void setUp() throws Exception {
        controller = new HelloController();
    }

    @After
    public void tearDown() throws Exception {

    }

    @Test
    public void testHello() throws Exception {
        String rs = controller.hello("test", new ModelAndView());

        assertThat(rs, is("hello"));
    }
}
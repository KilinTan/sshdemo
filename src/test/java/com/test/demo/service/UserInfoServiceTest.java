package com.test.demo.service;

import com.test.demo.dao.UserInfoDao;
import com.test.demo.domain.UserInfo;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationContext.xml")
public class UserInfoServiceTest extends AbstractTransactionalJUnit4SpringContextTests {

    @Autowired
    private UserInfoService userInfoService;

    @Autowired
    UserInfoDao userInfoDao;

    @Before
    public void setUp() throws Exception {

    }

    @After
    public void tearDown() throws Exception {

    }

    @Test
    public void testSave() throws Exception {
        UserInfo userInfo = new UserInfo();
        userInfo.setName("tttttt");
        userInfo.setGender(false);
        userInfo.setAddress("address");
        boolean rs = userInfoService.save(userInfo);

        assertThat(rs, is(true));
        UserInfo tmp = userInfoDao.load(userInfo.getName());
        assertThat(tmp, notNullValue());
        assertThat(tmp, sameInstance(userInfo));
    }

    @Test
    public void testList() throws Exception {

    }

    @Test
    public void testLoad() throws Exception {

    }
}
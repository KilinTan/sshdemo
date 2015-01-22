package com.test.demo.service.impl;

import com.test.demo.dao.UserInfoDao;
import com.test.demo.domain.UserInfo;
import com.test.demo.service.UserInfoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("userInfoService")
public class UserInfoServiceImpl implements UserInfoService {
    private static final Logger logger = LoggerFactory.getLogger(UserInfoServiceImpl.class);

    @Autowired
    private UserInfoDao userInfoDao;

    @Override
    @Transactional
    public boolean save(UserInfo userInfo) {
        String password = userInfo.getPassword();
        password += "encrypted";
        userInfo.setPassword(password);
        return userInfoDao.save(userInfo);
    }

    @Override
    @Transactional(readOnly = true)
    public List<UserInfo> list() {
        return userInfoDao.list();
    }

    @Transactional
    public UserInfo load(String name) {
        return userInfoDao.load(name);
    }
}

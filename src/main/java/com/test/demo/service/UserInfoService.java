package com.test.demo.service;


import com.test.demo.domain.UserInfo;

import java.util.List;

public interface UserInfoService {

    public boolean save(UserInfo userInfo);

    public List<UserInfo> list();

    UserInfo load(String name);
}

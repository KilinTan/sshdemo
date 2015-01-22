package com.test.demo.controller;

import com.test.demo.domain.UserInfo;
import com.test.demo.service.UserInfoService;
import com.test.demo.service.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class HelloController {
    @Autowired
    private HelloService helloService;

    @Autowired
    @Qualifier("userInfoService")
    private UserInfoService userInfoService;

    @Value("${test.name}")
    private String name;

    @RequestMapping("/hello")
    public String hello(String name, ModelMap map) {
        if (name != null) {
            String tmp = helloService.hello(name);
            map.put("name", tmp);
        }
        return "hello";
    }

    @RequestMapping("/load")
    public String load(String name, ModelMap map) {
        if (StringUtils.isEmpty(name)) {
            name = this.name;
        }
        UserInfo userInfo = userInfoService.load(name);
        map.put("userInfo", userInfo);
        return "userinfo/success";
    }

    @RequestMapping("/save")
    public String save(UserInfo userInfo, ModelMap map) {
        if (userInfo != null && StringUtils.hasLength(userInfo.getName())) {
            boolean rs = userInfoService.save(userInfo);
            if (rs) {
                map.put("userInfo", userInfo);
            }
            return "userinfo/success";
        } else {
            map.put("userInfo", userInfo);
            return "userinfo/failed";
        }
    }

    @RequestMapping("/list")
    public String list(ModelMap map) {
        List<UserInfo> userInfoList = userInfoService.list();
        map.put("userInfoList", userInfoList);
        Map<String, String> mm = new HashMap<>();
        mm.put("aa", "bb");
        mm.put("cc", "dd");
        map.put("mm", mm);
        return "userinfo/list";
    }
}

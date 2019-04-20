package com.guanghuan3.homework.designpattern.adapter.service.impl;

import com.guanghuan3.homework.designpattern.adapter.service.LoginService;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Administrator
 * on 2019/4/20.
 */
public class LoginServiceImpl implements LoginService{

    public Map<String, Object> login(String username, String password) {
        if ("123".equals(username) && "456".equals(password)) {
            Map<String, Object> result = new HashMap<>();
            result.put("name", "张山");
            result.put("gender", "男");
        }
        return null;
    }

}

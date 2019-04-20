package com.guanghuan3.homework.designpattern.adapter.service.impl;

import com.guanghuan3.homework.designpattern.adapter.service.LoginService;
import com.guanghuan3.homework.designpattern.adapter.service.TokenLoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Administrator
 * on 2019/4/20.
 */
@Service
public class TokenLoginServiceImpl implements TokenLoginService {

    @Autowired
    private LoginService loginServiceImpl;

    @Override
    public Object tokenLogin(String token) {
        Map<String, String> userInfo = adaptToken(token);
        String username = userInfo.get("username");
        String password = userInfo.get("password");

        return loginServiceImpl.login(username, password);
    }

    private Map<String, String> adaptToken(String token) {
        if (token != null && token.equals("123456")) {
            String username = "123";
            String password = "456";

            Map<String, String> result = new HashMap<>();
            result.put("username", username);
            result.put("password", password);
            return result;
        }
        return null;
    }

}

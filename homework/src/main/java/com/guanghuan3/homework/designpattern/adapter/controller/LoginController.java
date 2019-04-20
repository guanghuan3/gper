package com.guanghuan3.homework.designpattern.adapter.controller;

import com.guanghuan3.homework.designpattern.adapter.model.LoginModel;
import com.guanghuan3.homework.designpattern.adapter.service.LoginService;
import com.guanghuan3.homework.designpattern.adapter.service.TokenLoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by Administrator
 * on 2019/4/20.
 */
@Controller
public class LoginController {

    @Autowired
    private LoginService loginServiceImpl;

    @Autowired
    private TokenLoginService tokenLoginServiceImpl;

    /**
     * 原有登录方式
     * @param request
     * @param response
     * @param loginModel
     * @return
     */
    public Object usernameAndPasswordLogin(HttpServletRequest request, HttpServletResponse response, LoginModel loginModel) {
        String username = loginModel.getUsername();
        String password = loginModel.getPassword();

        return loginServiceImpl.login(username, password);
    }

    /**
     * 第三方token登录
     * @param token
     * @return
     */
    public Object tokenLogin(String token) {
        return tokenLoginServiceImpl.tokenLogin(token);
    }
}

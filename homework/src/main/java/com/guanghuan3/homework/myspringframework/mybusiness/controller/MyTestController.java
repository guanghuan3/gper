package com.guanghuan3.homework.myspringframework.mybusiness.controller;

import com.guanghuan3.homework.myspringframework.annotation.MyController;
import com.guanghuan3.homework.myspringframework.annotation.MyRequestParam;
import com.guanghuan3.homework.myspringframework.mybusiness.service.IMyTestService;
import com.guanghuan3.homework.myspringframework.mybusiness.service.impl.MyTestServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by Administrator
 * on 2019/4/20.
 */
@MyController
public class MyTestController {

    @Autowired
    private IMyTestService myTestServiceImpl;

    public String test1(@MyRequestParam String name) {
        return null;
    }

    public String error(HttpServletRequest request, HttpServletResponse response) {
        return null;
    }

    public String notFound(HttpServletRequest request, HttpServletResponse response) {
        return null;
    }
}

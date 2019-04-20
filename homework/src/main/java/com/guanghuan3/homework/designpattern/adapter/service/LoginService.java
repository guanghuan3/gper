package com.guanghuan3.homework.designpattern.adapter.service;

import java.util.Map;

/**
 * Created by Administrator
 * on 2019/4/20.
 */
public interface LoginService {

    Map<String, Object> login(String username, String password);
}

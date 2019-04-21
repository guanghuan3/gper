package com.guanghuan3.homework.myspringframework.mybusiness.service.impl;

import com.guanghuan3.homework.myspringframework.annotation.MyService;
import com.guanghuan3.homework.myspringframework.mybusiness.service.IMyTestService;
import com.guanghuan3.homework.myspringframework.utils.MyStringUtils;

/**
 * Created by Administrator
 * on 2019/4/20.
 */
@MyService
public class MyTestServiceImpl implements IMyTestService {

    public String test(String name) {
        return MyStringUtils.isEmpty(name) ? "这家伙很懒，什么也没留下" : name;
    }
}

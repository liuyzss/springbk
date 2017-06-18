package com.blueknight.dubbo.server.impl;

import com.blueknight.dubbo.server.api.HelloDubboService;
import org.springframework.stereotype.Service;

/**
 * Created by liuyang on 2017/6/18.
 */
@Service("helloDubboService")
public class HelloDubboServiceImpl implements HelloDubboService {
    public void sayHello(String name) {
        System.out.println("--------------------- dubbo -------------:Hello "+name);
    }
}

package com.blueknight.dubbo.server.impl;

import com.blueknight.dubbo.server.api.HelloDubboService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

/**
 * Created by liuyang on 2017/6/18.
 */
@Service("helloDubboService")
public class HelloDubboServiceImpl implements HelloDubboService {
    Logger logger = LoggerFactory.getLogger(this.getClass());
    public String sayHello(String name) {
        logger.error("hhhhhhhhh--------------------- dubbo -------------:Hello "+name);
        return "Hello "+name;
    }
}

package com.blueknight.dubbo.server.consumer;

import com.blueknight.dubbo.server.api.HelloDubboService;
import org.junit.Test;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;

import javax.annotation.Resource;

/**
 * Created by liuyang on 2017/6/18.
 */
@ContextConfiguration(locations = {"classpath:/springbk-*.xml"})
@Configuration
public class HelloTest extends AbstractJUnit4SpringContextTests {

    @Resource
    private HelloDubboService helloDubboService;
    @Test
    public void sayHello(){
        System.out.println("start ...");
        String re = helloDubboService.sayHello("liuyang");
        System.out.println("dubbo end :"+re);
    }
}

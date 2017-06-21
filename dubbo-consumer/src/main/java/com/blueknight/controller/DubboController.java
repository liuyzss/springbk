package com.blueknight.controller;

import com.blueknight.dubbo.server.api.HelloDubboService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

@Controller
@RequestMapping("/dubbo")
public class DubboController {

    //service类
    @Resource(name = "helloDubboService")
    private HelloDubboService helloDubboService;

    @RequestMapping("/hello")
    @ResponseBody
    public Object findUser() {
        helloDubboService.sayHello("liuyang");
        System.out.println("++++++++++++++++++++++++hello");
        return "hello";
    }
}
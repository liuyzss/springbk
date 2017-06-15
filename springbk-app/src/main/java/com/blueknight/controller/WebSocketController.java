package com.blueknight.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
@Controller
@RequestMapping("/ws")
public class WebSocketController {

    @RequestMapping("/test")
    public Object index() throws Exception {
        return "ws/hello";
    }
}
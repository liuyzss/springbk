package com.blueknight.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by liuyang on 2017/7/12.
 */
@Controller
@RequestMapping("/template")
public class VelocityController {

    @RequestMapping("/contract")
    public void contract(HttpServletRequest request, HttpServletResponse response){
        try {
            response.setContentType("text/html;charset=utf-8");
            PrintWriter out=response.getWriter();
            out.println("<html><head></head><body>1111</body></html>");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

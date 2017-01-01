package com.blueknight.controller;

import com.blueknight.dao.po.User;
import com.blueknight.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/user")
public class UserController {

    //service类
    @Autowired
    private UserService userService;

    @ModelAttribute("username")
    public String replaceSensitiveWords(String username){

        if(null != username){
            username = username.replaceAll("D","T");
        }
        return username;
    }
    /**
     * 查找所用用户控制器方法
     * @return
     * @throws Exception
     */
    @RequestMapping("/findUser")
    public ModelAndView findUser()throws Exception{
        ModelAndView modelAndView = new ModelAndView();

        //调用service方法得到用户列表
        List<User> users = userService.findUser();
        //将得到的用户列表内容添加到ModelAndView中
        modelAndView.addObject("users",users);
        //设置响应的jsp视图
        modelAndView.setViewName("findUser");

        return modelAndView;
    }
    @RequestMapping("/username")
    @ResponseBody
    public Object modeAttr(RedirectAttributes attributes,Model model)throws Exception{
        attributes.addFlashAttribute("username",model.asMap().get("username"));
        System.out.println(model.asMap().get("username"));
        model.addAttribute("test","test");
        Map map = new HashMap<String,String>();
        map.put("name","liuyang");
        return map;
    }
}
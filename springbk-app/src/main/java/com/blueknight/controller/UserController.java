package com.blueknight.controller;

import com.blueknight.dao.po.User;
import com.blueknight.mapper.UserMapper;
import com.blueknight.service.UserService;
import com.blueknight.vo.UserVo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.JmsException;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.annotation.Resource;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.ObjectMessage;
import javax.jms.Session;
import javax.validation.Valid;
import java.util.*;
import java.util.concurrent.*;

@Controller
@RequestMapping("/user")
public class UserController {
    private static final Logger LOGGER = LoggerFactory.getLogger(UserController.class);

    //service类
    @Autowired
    private UserService userService;

    @Resource
    private UserMapper userMapper;
    @ModelAttribute("username")
    public String replaceSensitiveWords(String username) {

        if (null != username) {
            username = username.replaceAll("D", "T");
        }
        return username;
    }

    /**
     * 查找所用用户控制器方法
     *
     * @return
     * @throws Exception
     */
    @RequestMapping("/findUser")
    public ModelAndView findUser(@RequestParam("count") int count) throws Exception {
        ModelAndView modelAndView = new ModelAndView();

        List list = new ArrayList();
        for (int i = 0;i< count;i++){
            byte[] bytes = new byte[1024];
            list.add(bytes);
        }
        //调用service方法得到用户列表
        List<User> users = userService.findUser();
        //将得到的用户列表内容添加到ModelAndView中
        modelAndView.addObject("users", users);
        //设置响应的jsp视图
        modelAndView.setViewName("findUser");

        return modelAndView;
    }

    @RequestMapping("/username")
    @ResponseBody
    public Object modeAttr(RedirectAttributes attributes, Model model) throws Exception {
        attributes.addFlashAttribute("username", model.asMap().get("username"));
        System.out.println(model.asMap().get("username"));
        model.addAttribute("test", "test");
        Map map = new HashMap<String, String>();
        map.put("name", "liuyang");
        return map;
    }

    @RequestMapping(value = "/add/{rollback}", method = RequestMethod.GET)
    @ResponseBody
    public Object addUser(@PathVariable("rollback") Integer rollback) throws Exception {
        userService.testInsert(rollback);
        Map map = new HashMap<String, String>();
        map.put("name", "liuyang");
        return map;
    }

    @RequestMapping(value = "/addUser", method = RequestMethod.GET)
    @ResponseBody
    public Object add(@Valid UserVo userVo, BindingResult result) throws Exception {
        User user = new User();
        BeanUtils.copyProperties(userVo, user);
        userService.add(user);
        Map map = new HashMap<String, String>();
        if (result.hasErrors()) {
            map.put("error",result.getAllErrors());
        } else {
            map.put("date", user);
        }
        return map;
    }

    @RequestMapping(value = "/dbLock", method = RequestMethod.GET)
    @ResponseBody
    public Object dbLock() throws Exception {

        User user = new User();
        user.setStuNumber("123456");
        user.setUsername("liuyang");
        user.setBirthday(new Date());
        user.setSex("F");
        user.setAddress("奥森");
        int threadSize = 200;
        CountDownLatch startLock = new CountDownLatch(1);
        CountDownLatch endLock = new CountDownLatch(threadSize);

        ExecutorService executorService = Executors.newFixedThreadPool(threadSize);

        List<Future> futureList = new ArrayList<Future>();

        for (int i = 0; i < threadSize; i++) {

            Future task = executorService.submit(new Callable<Object>() {

                @Override
                public Object call() throws Exception {
                    startLock.await();
                    userService.testDeadLock(user);
                    endLock.countDown();
                    return 0;
                }
            });

        }

        System.out.println(userMapper.select(user.getStuNumber()));
        startLock.countDown();
        try {
            endLock.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "hello";
    }
}
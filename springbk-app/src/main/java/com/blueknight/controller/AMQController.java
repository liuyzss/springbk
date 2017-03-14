package com.blueknight.controller;

import com.blueknight.dao.po.User;
import com.blueknight.service.UserService;
import com.blueknight.vo.UserVo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
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
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/amq")
public class AMQController {

    @Resource
    private JmsTemplate jmsTemplate;

    @RequestMapping(value = "/send", method = RequestMethod.GET)
    @ResponseBody
    public Object send(@Valid final UserVo userVo, BindingResult result){
        //jmsTemplate.convertAndSend("springbk.queue",userVo);
        jmsTemplate.send("springbk.queue", new MessageCreator() {
            public Message createMessage(Session session) throws JMSException {
                return session.createObjectMessage(userVo);
            }
        });
        return "ok";
    }
    @RequestMapping(value = "/receive", method = RequestMethod.GET)
    @ResponseBody
    public Object receive(){
        try {
            ObjectMessage msg = (ObjectMessage) jmsTemplate.receive();
            System.out.println(msg.getObject());
            return msg.getObject();
//            Object obj = jmsTemplate.receiveAndConvert();
//            System.out.println(obj);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "ok";
    }
}
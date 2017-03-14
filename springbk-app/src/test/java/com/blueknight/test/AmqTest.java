package com.blueknight.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.jms.JmsException;
import org.springframework.jms.core.JmsOperations;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.ObjectMessage;
import javax.jms.Session;

/**
 * Created by liuyang on 2017/3/14.
 */

@RunWith(SpringJUnit4ClassRunner.class)  //使用junit4进行测试
@ContextConfiguration(locations = {"classpath*:config/spring/applicationContext-*.xml"})
public class AmqTest {
    @Resource
    private JmsTemplate jmsTemplate;

    @Test
    public void testProducer(){
        jmsTemplate.send("springbk.queue", new MessageCreator() {
            public Message createMessage(Session session) throws JMSException {
                return session.createObjectMessage("HELLO");
            }
        });

    }

    @Test
    public void testConsumer(){
        try {
            ObjectMessage msg = (ObjectMessage) jmsTemplate.receive();
            System.out.println(msg.getObject());
        } catch (JmsException e) {
            e.printStackTrace();
        } catch (JMSException e) {
            e.printStackTrace();
        }
    }
}

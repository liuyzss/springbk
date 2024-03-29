package com.blueknight.demo.activemq;

import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;
import java.util.Arrays;

public class QueueConsumer {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		ConnectionFactory connectionFactory;
	    // Connection ：JMS 客户端到JMS Provider 的连接  
	    Connection connection = null;
	    // Session： 一个发送或接收消息的线程  
	    Session session;
	    // Destination ：消息的目的地;消息发送给谁.  
	    Destination destination;
	    // 消费者，消息接收者  
	    MessageConsumer consumer;
	    connectionFactory = new ActiveMQConnectionFactory("admin", "admin", "tcp://127.0.0.1:61616");
	    ActiveMQConnectionFactory test = (ActiveMQConnectionFactory) connectionFactory;
	    //test.setTrustedPackages(Arrays.asList("com.blueknight.demo.activemq"));
	    try {
	        // 构造从工厂得到连接对象  
	        connection = connectionFactory.createConnection();
	        // 启动  
	        connection.start();
	        // 获取操作连接  
	        //这个最好还是有事务
	        session = connection.createSession(Boolean.FALSE, Session.AUTO_ACKNOWLEDGE);
	        // 获取session注意参数值xingbo.xu-queue是一个服务器的queue，须在在ActiveMq的console配置  
	        destination = session.createQueue("test-queue");
	        consumer = session.createConsumer(destination);
	        consumer.setMessageListener(new MessageListener() {
	            public void onMessage(Message message) {
	                try {
	                    Student bean = (Student) ((ObjectMessage)message).getObject();
	                    System.out.println(bean);
	                    if (null != message) {
	                        System.out.println("收到消息" + bean.getName());
	                    }
	                } catch (Exception e) {
	                	e.printStackTrace();
	                    // TODO: handle exception
	                }
	            }
	        });
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	}

}

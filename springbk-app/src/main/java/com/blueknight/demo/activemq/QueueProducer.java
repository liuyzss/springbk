package com.blueknight.demo.activemq;

import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;

public class QueueProducer {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			ConnectionFactory factory = new ActiveMQConnectionFactory("admin", "admin", "tcp://127.0.0.1:61616");
			Connection connection = factory.createConnection();
			connection.start();
			Session session = connection.createSession(false, Session.CLIENT_ACKNOWLEDGE);
			Destination destination = session.createQueue("test-queue");
			MessageProducer producer = session.createProducer(destination);
			producer.setDeliveryMode(DeliveryMode.NON_PERSISTENT);
			Student stu = new Student();
			for(int i = 0; i<10;i++){
				stu.setName("test"+i);
				producer.send(session.createObjectMessage(stu));
			}
			producer.close();
			System.out.println("END ++++++");
		} catch (JMSException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}

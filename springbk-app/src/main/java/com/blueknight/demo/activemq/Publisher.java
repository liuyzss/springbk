package com.blueknight.demo.activemq;

import org.eclipse.paho.client.mqttv3.MqttClient;
import org.eclipse.paho.client.mqttv3.MqttConnectOptions;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.eclipse.paho.client.mqttv3.MqttMessage;
import org.eclipse.paho.client.mqttv3.persist.MemoryPersistence;  
  
public class Publisher {  
    public static void main(String[] args) {  
        String topic = "TopicOfLeo";  
        String content = "Hello Leo hhh!";  
        int qos = 1;//0:msg只发1次,并且不需要确认.  1:msg至少发1次,需要确认.   2.发且仅发1次,并且需要进行4次挥手.  
        String broker = "tcp://127.0.0.1:1883";  
        String clientId = "publisher1";  
        MemoryPersistence persistence = new MemoryPersistence();  
  
        try {  
            MqttClient client = new MqttClient(broker, clientId, persistence);  
            MqttConnectOptions connOpts = new MqttConnectOptions();  
            connOpts.setCleanSession(false);//第一次启动是否清除session  
            client.connect(connOpts);  
            MqttMessage message = new MqttMessage(content.getBytes());  
            message.setQos(qos);  
            client.publish(topic, message);  
            client.disconnect();  
            System.exit(0);  
        } catch (MqttException me) {  
            System.out.println("reason " + me.getReasonCode());  
            System.out.println("msg " + me.getMessage());  
            System.out.println("loc " + me.getLocalizedMessage());  
            System.out.println("cause " + me.getCause());  
            System.out.println("excep " + me);  
            me.printStackTrace();  
        }  
    }  
}  


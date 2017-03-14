package com.blueknight.demo.activemq;

import org.eclipse.paho.client.mqttv3.*;
import org.eclipse.paho.client.mqttv3.persist.MemoryPersistence;  
  
public class Subscriber {  
    public static void main(String[] args) {  
        String topic = "TopicOfLeo";  
        String broker = "tcp://127.0.0.1:1883";  
        String clientId = "Subscriber1";  
        MemoryPersistence persistence = new MemoryPersistence();  
  
        try {  
            MqttClient client = new MqttClient(broker, clientId, persistence);  
            MqttConnectOptions connOpts = new MqttConnectOptions();  
            connOpts.setCleanSession(false);  
            client.connect(connOpts);  
            client.subscribe(topic, new IMqttMessageListener() {  
  
                public void messageArrived(String topic, MqttMessage message) throws Exception {  
                    System.out.println(topic + " -> " + message);  
                }  
            });  
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



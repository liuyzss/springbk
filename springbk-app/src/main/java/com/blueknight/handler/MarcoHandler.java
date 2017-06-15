package com.blueknight.handler;

import com.blueknight.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.AbstractWebSocketHandler;

/**
 * Created by liuyang on 2017/3/20.
 */
public class MarcoHandler extends AbstractWebSocketHandler {
    public static Logger logger = LoggerFactory.getLogger(UserService.class);
    @Override
    protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
        logger.info("============= Received message:{}",message.getPayload());
        super.handleTextMessage(session, message);
        Thread.sleep(2000L);
        session.sendMessage(new TextMessage("I am Srping!!!"));
    }
}

package selenium.testingmachine.socket;

import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

public class MyWebSocketHandler extends TextWebSocketHandler {

    @Override
    public void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
        // Echo the received message
        session.sendMessage(new TextMessage("Echo: " + message.getPayload()));
    }

    @Override
    public void afterConnectionEstablished(WebSocketSession session) throws Exception {
        // Send a message when the connection is established
        session.sendMessage(new TextMessage("Connection established"));
    }
}

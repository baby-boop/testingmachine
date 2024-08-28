package selenium.testingmachine.socket;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;

@Slf4j
@Service
public class SocketService extends TextWebSocketHandler {

    public static List<WebSocketSession> sessions = new ArrayList<>();
    public static final ConcurrentHashMap<String, CompletableFuture<String>> sessionResponses = new ConcurrentHashMap<>();

    private final ObjectMapper objectMapper = new ObjectMapper();

    @Override
    public void afterConnectionEstablished(WebSocketSession session) {
        sessions.add(session);
    }

    @Override
    public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {
        super.afterConnectionClosed(session, status);
        sessions = sessions.stream().filter(webSocketSession -> !webSocketSession.getId().equals(session.getId())).collect(Collectors.toList());
    }

    @Override
    public void handleTextMessage(WebSocketSession session, TextMessage message) {
        try {
            String payload = this.objectMapper.readValue(message.getPayload(), String.class);
            log.info("received text message: {}", payload);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        }
    }

    public void sendMessageToAll(String message) {
        for (WebSocketSession session : sessions) {
            try {
                session.sendMessage(new TextMessage(message));
            } catch (IOException e) {
                log.error(e.getMessage());
            }
        }
    }

}
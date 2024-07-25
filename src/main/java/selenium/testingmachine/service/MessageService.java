package selenium.testingmachine.service;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

public class MessageService {
private static ConcurrentMap<String, String> messages = new ConcurrentHashMap<>();

    public static void addMessage(String key, String message) {
        messages.put(key, message);
    }

    public static String getMessage(String key) {
        return messages.get(key);
    }

    public static void clearMessages() {
        messages.clear();
    }
}

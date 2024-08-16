package selenium.testingmachine.controller;

public class Finished {
    private static ThreadLocal<String> finishMessage = ThreadLocal.withInitial(() -> null);

    public static String getFinishMessage() {
        return finishMessage.get();
    }

    public static void setFinishMessage(String message) {
        finishMessage.set(message);
    }

    public static boolean hasFinishMessage() {
        String message = finishMessage.get();
        return message != null && !message.trim().isEmpty();
    }

    public static void clearFinishMessage() {
        finishMessage.remove();
    }
}

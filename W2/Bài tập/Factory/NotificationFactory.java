public class NotificationFactory {
    public static Notification createNotification(String type) {
        if (type.equalsIgnoreCase("sms")) {
            return new SmsNotification();
        } else if (type.equalsIgnoreCase("push")) {
            return new PushNotification();
        } else {
            throw new IllegalArgumentException("Unknown notification type: " + type);
        }
    }
}

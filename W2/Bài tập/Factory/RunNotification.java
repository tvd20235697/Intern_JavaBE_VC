public class RunNotification {
    public static void main(String[] args) {
        Notification smsNotification = NotificationFactory.createNotification("sms");
        smsNotification.sendNotification("Hello via SMS!");
        Notification pushNotification = NotificationFactory.createNotification("push");
        pushNotification.sendNotification("Hello via Push!");
        Notification mailNotification = NotificationFactory.createNotification("mail");
        mailNotification.sendNotification("Hello via Mail!");
    }
}

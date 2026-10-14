public class RunOrderChannel {
    public static void main(String[] args) {
        OrderChannel orderChannel = new OrderChannel();

        Observer emailService = new EmailService();
        Observer logService = new LogService();
        Observer notifyService = new NotifyService();

        orderChannel.addObserver(emailService);
        orderChannel.addObserver(logService);
        orderChannel.addObserver(notifyService);

        orderChannel.notifyObservers();
    }
}

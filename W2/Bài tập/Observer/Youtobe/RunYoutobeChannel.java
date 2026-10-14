public class RunYoutobeChannel {
    public static void main(String[] args) {
        YoutobeChannel channel = new YoutobeChannel();

        subcriber sub1= new subcriber("Duy");
        subcriber sub2= new subcriber("Thuy");
        subcriber sub3= new subcriber("tao");

        channel.subcribe(sub1);
        channel.subcribe(sub2);
        channel.subcribe(sub3);

        channel.notifySubscribers("New Video 1");
        channel.notifySubscribers("New Video 2");

        channel.unsubcribe(sub3);
        channel.printSubscribers();
    }
}

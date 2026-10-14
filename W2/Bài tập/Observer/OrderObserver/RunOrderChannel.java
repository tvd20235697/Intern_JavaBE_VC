
public class RunOrderChannel {
    public static void main(String[] args){
        OrderChannel order= new OrderChannel();
        Order sms1= new SmsService();
        Order not= new NotifiService();
        Order log=new LogService();
        order.addOrderService(sms1);
        order.addOrderService(not);
        order.addOrderService(log);
        order.updateOrderService();
    }
}

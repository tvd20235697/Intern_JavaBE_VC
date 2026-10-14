public class PaymentStrategy {
    private Payment paymentStrategy;
    public PaymentStrategy(Payment paymentStrategy){
        this.paymentStrategy = paymentStrategy;
    }

    public void pay(int mount){
        paymentStrategy.pay(mount);
    }
}

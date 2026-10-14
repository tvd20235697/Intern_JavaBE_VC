public class RunPaymentStrategy {
    public static void main(String[] args) {
        PaymentStrategy momoPaymentStrategy = new PaymentStrategy(new MomoPayment());
        momoPaymentStrategy.pay(100000);
        PaymentStrategy creditCardPaymentStrategy = new PaymentStrategy( new CreditCardPayment());
        creditCardPaymentStrategy.pay(200000);
        PaymentStrategy bankPaymentStrategy = new PaymentStrategy( new BankPayment());
        bankPaymentStrategy.pay(50000);
    }
}

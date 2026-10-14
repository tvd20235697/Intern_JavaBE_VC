public class RunPayment {
    public static void main(String[] args) {
        Payment momoPayment = PaymentFactory.getPayment("momo");
        momoPayment.pay(100);

        Payment tpBankPayment = PaymentFactory.getPayment("tpbank");
        tpBankPayment.pay(200);

        Payment scBankPayment = PaymentFactory.getPayment("scbank");
        scBankPayment.pay(1000000);
    }
}

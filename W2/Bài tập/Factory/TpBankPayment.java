public class TpBankPayment implements Payment {
    @Override
    public void pay(int amount) {
        System.out.println("Paying " + amount + " using TpBankPayment.");
    }
    
}

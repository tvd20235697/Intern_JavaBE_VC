public class MomoPayment implements Payment {
    @Override
    public void pay(int amount) {
        System.out.println("Paying " + amount + " using MomoPayment.");
    }
    
}

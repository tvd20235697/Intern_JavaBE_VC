public class CreditCardPayment implements Payment{
    @Override 
    public void pay(int mount){
        System.out.println(mount + " paid using CreditCardPayment");
    }
}

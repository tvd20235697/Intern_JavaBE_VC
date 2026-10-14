public class SCBankPayment implements Payment {
    @Override 
    public void pay(int mount){
        System.out.println("Paying " + mount + " using SCBankPayment ");
    }
}

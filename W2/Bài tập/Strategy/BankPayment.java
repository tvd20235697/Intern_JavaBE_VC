public class BankPayment implements Payment{
    @Override 
    public void pay(int mount){
        System.out.println("Da bank:" + mount);
    }
}

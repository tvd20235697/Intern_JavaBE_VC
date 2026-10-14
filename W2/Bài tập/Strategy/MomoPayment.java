public class MomoPayment implements Payment {
    @Override
    public void pay(int mount){
        System.out.println(mount + " paid using MomoPayment");
    }
}

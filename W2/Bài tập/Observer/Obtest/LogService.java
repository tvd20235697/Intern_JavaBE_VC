public class LogService implements Observer{
    @Override
    public void update() {
        System.out.println("Logged");
        throw new RuntimeException("Loi roi");
    }
    
}

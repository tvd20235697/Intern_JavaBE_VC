public class RunAppConfig {
    public static void main(String[] args) {
        Thread t1 = new Thread(() -> {
            AppConfig config1 = AppConfig.getInstance();
            
        });
        Thread t2 = new Thread(() -> {
            AppConfig config2 = AppConfig.getInstance();
        });

        t1.start();
        t2.start();
        try{
            t1.join();
            t2.join();
        }catch(InterruptedException e){
            e.printStackTrace();
        }
    }
}

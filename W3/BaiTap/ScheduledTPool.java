import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class ScheduledTPool {
    public static void main(String[] args) throws InterruptedException{
        ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(5);
        /*scheduler.scheduleWithFixedDelay(() -> {
            System.out.println("...");
        },0, 3, TimeUnit.SECONDS);*/
        for(int i = 1; i <= 5; i++){
            final int taskId = i;
            scheduler.scheduleWithFixedDelay(() -> {
                System.out.println("S1: " + Thread.currentThread().getName() + " Dang xu ly " + taskId);
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            },0,5, TimeUnit.SECONDS);
            /*scheduler.scheduleAtFixedRate(() -> {
                System.out.println("S2: "+ Thread.currentThread().getName() + " Dang xu ly " + taskId);
                try{
                    Thread.sleep(3000);
                }catch (InterruptedException e){
                    Thread.currentThread().interrupt();
                }
            },0, 5, TimeUnit.SECONDS);*/
            System.out.println("Loop: " + i);
            Thread.sleep(10000);
        }
        scheduler.shutdownNow();
    }
}

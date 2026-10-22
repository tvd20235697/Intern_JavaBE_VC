import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class BulkHeadDemo {
    private static final ExecutorService EmailPool = new ThreadPoolExecutor( 2, 2, 10, TimeUnit.SECONDS, new ArrayBlockingQueue<>(3), new ThreadPoolExecutor.AbortPolicy());
    private static final ExecutorService PaymentPool = new ThreadPoolExecutor( 2, 2, 10, TimeUnit.SECONDS, new ArrayBlockingQueue<>(3), new ThreadPoolExecutor.AbortPolicy());
    private static void sendMail(final int taskId){
        EmailPool.execute(() -> {
            System.out.println(Thread.currentThread().getName() + " Sending: "+ taskId);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        });
    }
    private static void payment(final int taskId){
        PaymentPool.execute(() -> {
            System.out.println(Thread.currentThread().getName() + " Paying: "+ taskId);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        });
    }
    public static void main(String[] args){
        for(int i = 1; i <= 5; i++){
            final int taskId=i;
            sendMail(taskId);
        }
        for(int i = 1; i <= 5; i++){
            final int taskId = i;
            payment(taskId);
        }
        EmailPool.shutdown();
        PaymentPool.shutdown();
    }
}

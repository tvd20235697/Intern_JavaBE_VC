import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class TPoolExecutor{
    public static void main(String[] args){
        try (ThreadPoolExecutor pool = new ThreadPoolExecutor(2,3,10,TimeUnit.SECONDS, new ArrayBlockingQueue<>(5), new ThreadPoolExecutor.CallerRunsPolicy())) {
            for( int i=1; i <= 20; i++){
                final int taskId = i;
                pool.execute(() -> {
                    System.out.println(Thread.currentThread().getName() + " Xu ly Task id:" + taskId);
                    try {
                        Thread.sleep(5000);
                    } catch (InterruptedException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }
                });
            }
            pool.shutdown();
        }
    }
}
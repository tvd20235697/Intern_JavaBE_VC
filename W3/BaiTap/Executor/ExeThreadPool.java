import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ExeThreadPool {
    public static void main(String[] args){
        ExecutorService pool = Executors.newFixedThreadPool(10);
        for(int i = 1 ; i <= 20 ; i++){
            int taskId = i;
            pool.submit(()->{
                System.out.println(Thread.currentThread().getName() + " Xu ly " + taskId);
            });
        }
        pool.shutdown();
    }
}

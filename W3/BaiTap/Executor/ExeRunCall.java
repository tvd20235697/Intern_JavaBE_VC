import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class ExeRunCall {
    public static void main(String[] args) throws Exception {
        ExecutorService pool = Executors.newFixedThreadPool(2);
        Runnable task = () -> {
            System.out.println("Dang xu ly ...");
        };
        Future<?> future = pool.submit(task);

        Callable<Integer> task2 = () -> {
            Thread.sleep(2000);
            return 200 + 100;
        };
        Thread bg = new Thread(() -> {
            while (true) {
                System.out.println("Dang chay nen");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    break;
                }
            }
        });
        bg.setDaemon(true);
        bg.start();

        Future<Integer> future2 = pool.submit(task2);
        System.out.println(future.get());
        System.out.println(future2.get());
        pool.shutdown();
    }
}

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ProducerConsumerDemo {
    public static void main(String[] args) throws InterruptedException {
        BlockingQueue<Integer> queue = new ArrayBlockingQueue<>(10);
        ExecutorService pool = Executors.newFixedThreadPool(3);

        Runnable producer = () -> {
            try {
                for (int i = 1; i <= 10; i++) {
                    queue.put(i);
                    System.out.println("Tao :" + i);
                }
                queue.put(-1);
                queue.put(-1);
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        };

        Runnable consumer = () -> {
            while (true) {
                try {
                    int i = queue.take();
                    if (i == -1) {
                        System.out.println("done");
                        break;
                    }
                    System.out.println("Dang xu ly: " + i);
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    break;
                }
            }
        };

        pool.submit(producer);
        pool.submit(consumer);
        pool.submit(consumer);

        pool.shutdown();
    }
}

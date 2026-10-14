import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class JobBlockingQueue {
    public static void main(String[] args) {
        BlockingQueue<String> queue = new ArrayBlockingQueue<>(5);
        Thread producer = new Thread(() -> {
            for(int i = 0; i < 10; i++) {
                try{
                    queue.put("Job: " + i);
                    System.out.println("Producer created: Job " + i);
                    System.out.println("Queue size: " + queue.size());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        Thread consumer = new Thread(() -> {
            for(int i = 0; i < 10; i++) {
                try{
                    String job = queue.take();
                    System.out.println("Consumer processed: " + job);
                    System.out.println("Queue size: " + queue.size());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        producer.start();
        consumer.start();
        try{
            producer.join();
            consumer.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

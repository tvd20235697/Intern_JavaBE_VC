public class AtomicThread {
    public static void main(String[] args){
        AtomicCounter counter = new AtomicCounter();
    Thread t1 = new Thread(() -> {
        for(int i = 0; i < 100000; i++){
            counter.increment();
        }
    });
    Thread t2 = new Thread(() -> {
        for(int i = 0; i < 100000; i++){
            counter.increment();
        }
    });
    t1.start();
    t2.start();
    try{
        t1.join();
        t2.join();
        System.out.println(counter.getCount());
    }catch(InterruptedException e){
        Thread.currentThread().interrupt();
    }
    }
}

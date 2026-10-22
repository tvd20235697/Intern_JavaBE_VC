public class TWaiting {
    static Object lock = new Object();
    public static void main(String[] args) throws InterruptedException{
        Thread t1 = new Thread(()->{
            synchronized(lock){
                System.out.println("T1 dang cho");
                try {
                    lock.wait();
                } catch (InterruptedException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
                System.out.println("T1 day");
                lock.notify();
            }
        });
        Thread t2 = new Thread(() -> {
            synchronized(lock){
                System.out.println("t2 ...");
                try {
                    lock.wait();
                } catch (InterruptedException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
                System.out.println("t2 day");
            }
        });
        Thread t3 = new Thread(() -> {
            synchronized(lock){
                System.out.println("...");
                lock.notify();
            }
        });
        t1.start();
        Thread.sleep(1000);
        System.out.println(t1.getState());
        t2.start();
        Thread.sleep(1000);
        System.out.println(t2.getState());
        t3.start();
        try {
            t1.join();
            t2.join();
            t3.join();
            System.out.println(t1.getState());
            System.out.println(t2.getState());
            System.out.println(t3.getState());
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}

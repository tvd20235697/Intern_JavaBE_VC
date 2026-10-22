public class TBlocked {
    static Object lock = new Object();

    public static void main(String[] args){
        Thread t1 = new Thread(()-> {
                synchronized (lock) {
                    System.out.println("Tao da chiem lock");
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }
                    System.out.println("Nha lock");
                }
            }
        );
        Thread t2 = new Thread(()->{
            System.out.println("Tao can lock");
            synchronized(lock){
                System.out.println("Lock cua t");
            }
        });
        System.out.println(t1.getState());
        System.out.println(t2.getState());
        t1.start();
        t2.start();
        System.out.println(t1.getState());
        System.out.println(t2.getState());
        try{
            t1.join();
            System.out.println(t1.getState());
            t2.join();
            System.out.println(t2.getState());
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}

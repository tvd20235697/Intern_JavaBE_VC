public class TDaemon {
    static Object lock = new Object();
    public static void main(String[] args){
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
        Thread t1 = new Thread(() -> {
            synchronized(lock){
                try {
                    Thread.sleep(10000);
                    System.out.println("Xong");
                } catch (InterruptedException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
        });
        bg.setDaemon(true);
        bg.start();
        t1.start();
        
    }
}

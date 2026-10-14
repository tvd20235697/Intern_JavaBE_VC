public class runsgt {
    public static void main(String[] args) {
        Thread t1= new Thread(()->{
            sgt s1= sgt.getInstance();
        });
        Thread t2= new Thread(()->{
            sgt s2= sgt.getInstance();
        });
        t1.start();
        t2.start();
        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

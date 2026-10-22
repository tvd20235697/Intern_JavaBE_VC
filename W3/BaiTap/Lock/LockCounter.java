import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class LockCounter {
    int count = 0;
    private final Lock lock = new ReentrantLock();
    public void increment(){
        try{
            lock.lockInterruptibly();
            try{
                count++;
            }finally{
                lock.unlock();
            }
        }catch(InterruptedException e){
            Thread.currentThread().interrupt();
        }
    }
}

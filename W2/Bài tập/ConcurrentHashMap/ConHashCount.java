import java.util.HashMap;
import java.util.Scanner;
import java.util.concurrent.ConcurrentHashMap;

public class ConHashCount {
    public static void main(String[] args){
        ConcurrentHashMap<String, Integer> map = new ConcurrentHashMap<>();
        Scanner sc= new Scanner(System.in);
        String s=sc.nextLine();
        Thread t1 = new Thread(() -> {
            for(String word: s.split(" ")){
                map.merge(word, 1, Integer::sum);
                System.out.println( "Size of map: " + map.size());
                System.out.println( "Contents of map: " + map);
            }
        });
        Thread t2 = new Thread(() -> {
            for(String word: s.split(" ")){
                map.merge(word, 1, Integer::sum);
                System.out.println( "Size of map: " + map.size());
                System.out.println( "Contents of map: " + map);
            }
        });

        t1.start();
        t2.start();
        try {
            t1.join();
            t2.join();
        }catch (InterruptedException e) {
            e.printStackTrace();
        }
    
    }
}

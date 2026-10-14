import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.addAll(List.of(10,20,20,30,30,40,40,50,50,60,60,70,70,80,80,90,90,100));
        list.add(20);
        list.sort(null);
        System.out.println("Before removing duplicates:");
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
        for (int i = 1; i < list.size(); i++) {
            if(list.get(i)==list.get(i-1)){
                list.remove(i);
                i--;
            }
        }
        System.out.println("After removing duplicates:");
       for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
    }
    
}

import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;

public class HashS {
    public static void main(String[] args) {
        HashSet<String> set = new HashSet<>();
        HashMap<String, Integer> map = new HashMap<>();
        Scanner sc= new Scanner(System.in);
        String s= sc.nextLine();
        for(String word: s.split(" ")){
            if(set.contains(word)){
                System.out.println("Duplicate word found: " + word);
            }
            else{
                set.add(word);
            }
        }
        System.out.println(set);
        for(String word: s.split(" ")){
            if(map.containsKey(word)){
                map.put(word, map.get(word)+1);
            }else{
                map.put(word, 1);
            }
        }
        System.out.println(map);
    }
}

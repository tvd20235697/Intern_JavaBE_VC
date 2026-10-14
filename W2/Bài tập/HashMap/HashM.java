import java.util.HashMap;
import java.util.Scanner;

public class HashM {
    public static void main(String[] args) {
        HashMap<String, Integer> map = new HashMap<>();
        map.put("Duy",1);
        System.out.println(map);
        map.put("Duy",1);
        System.out.println(map);
        map.put("HahA",1);
        System.out.println(map);
        System.out.println(map.get(0));
        /*Scanner sc= new Scanner(System.in);
        String s= sc.nextLine();
        for(String word: s.split(" ")){
            if(map.containsKey(word)){
                map.put(word, map.get(word)+1);
            }else{
                map.put(word, 1);
            }
        }
        System.out.println(map);*/
    }
}

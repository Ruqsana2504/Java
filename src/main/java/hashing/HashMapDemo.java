package hashing;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class HashMapDemo {

    public static void main(String[] args) {
        HashMap<String, Integer> map = new HashMap<>();

        map.put("India", 120);
        map.put("US", 30);
        map.put("China", 150);

        System.out.println(map);

        map.put("China", 180);
        System.out.println(map);

        //Searching
        if (map.containsKey("China"))
            System.out.println("Key Found ");

        //Iteration 1
        for (Map.Entry<String, Integer> e : map.entrySet())
            System.out.println(e.getKey() + " " + e.getValue());

        //Iteration 2
        Set<String> keys = map.keySet();
        for (String key : keys)
            System.out.println(key + " " + map.get(key));

        //Remove
        map.remove("China");
        System.out.println(map);
    }
}

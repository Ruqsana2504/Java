package hashing;

import java.util.HashSet;
import java.util.Iterator;

public class HashSetDemo {

    public static void main(String[] args) {
        HashSet<Integer> hs = new HashSet<>();

        //Time Complexity - O(1)
        hs.add(1);
        hs.add(2);
        hs.add(3);
        hs.add(1);

        if (hs.contains(1))
            System.out.println("Set contains 1");

        System.out.println("Set : " + hs);

        System.out.println("Size of the set : " + hs.size());

        Iterator<Integer> it = hs.iterator();
        while (it.hasNext())
            System.out.println(it.next());

        hs.remove(1);

        if (!hs.contains(1))
            System.out.println("Removed 1 from set");

        if (!hs.isEmpty())
            System.out.println("set is not empty");
    }
}

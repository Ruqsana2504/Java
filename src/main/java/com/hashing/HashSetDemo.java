package com.hashing;

import java.util.HashSet;

public class HashSetDemo {

    static void main() {
        HashSet<Integer> hs = new HashSet<>();

        //Time Complexity - O(1)
        hs.add(1);
        hs.add(2);
        hs.add(3);
//        hs.add(1);

        if (hs.contains(1))
            System.out.println("Set contains 1");

        System.out.println("Set : " + hs);

        System.out.println("Size of the set : " + hs.size());

        for (Integer h : hs) System.out.println(h);

        hs.remove(1);

        if (!hs.contains(1))
            System.out.println("Removed 1 from set");

        if (!hs.isEmpty())
            System.out.println("set is not empty");
    }
}

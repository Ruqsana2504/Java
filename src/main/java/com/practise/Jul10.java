package com.practise;

import java.util.HashSet;
import java.util.LinkedList;

public class Jul10 {

    static class HashMap<K, V> {


        public class Node {
            K key;
            V value;

            public Node(K key, V value) {
                this.key = key;
                this.value = value;
            }
        }

        private int n; //nodes
        private int N; //buckets
        private LinkedList<Node>[] buckets;

        private HashMap() {
            this.N = 4;
            buckets = new LinkedList[4];
            for (int i = 0; i < 4; i++) {
                buckets[i] = new LinkedList<>();
            }
        }

        private int hashFunction(K key) {
            return Math.abs(key.hashCode()) % N;
        }

        private int searchInLl(K key, int bi) {
            for (int i = 0; i < buckets[bi].size(); i++) {
                if (buckets[bi].get(i).key.equals(key)) {
                    return i; // Found the key, return index
                }
            }
            return -1;
        }

        public void put(K key, V value) {
            int bi = hashFunction(key);
            int di = searchInLl(key, bi);
            if (di == -1) {
                Node node = new Node(key, value);
                buckets[bi].add(node);
                n++;
            } else {
                buckets[bi].get(di).value = value;
            }

            int lambda = n / N;
            if (lambda > 2) {
                reHashing();
            }
        }

        private void reHashing() {
            LinkedList<Node> oldBucket[] = buckets;
            buckets = new LinkedList[2 * N];
            for (int i = 0; i < 2 * N; i++) {
                buckets[i] = new LinkedList<>();
            }
            for (LinkedList<Node> ll : oldBucket) {
                for (Node node : ll) {
                    put(node.key, node.value);
                }
            }

        }

        public boolean isEmpty() {
            return n == 0;
        }

        public V remove(K key) {
            int bi = hashFunction(key);
            int di = searchInLl(key, bi);
            if (di == -1) {
                return null; // Key not found
            } else {
                Node node = buckets[bi].remove(di);
                n--;
                return node.value; // Return the removed value
            }
        }

        public boolean containsKey(K key) {
            int bi = hashFunction(key);
            return searchInLl(key, bi) != -1;
        }

        public V get(K key) {
            int bi = hashFunction(key);
            int di = searchInLl(key, bi);
            if (di == -1) {
                return null; // Key not found
            } else {
                return buckets[bi].get(di).value; // Return the value associated with the key
            }
        }

        public HashSet<K> keySet() {
            HashSet<K> keys = new HashSet<>();
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < buckets[i].size(); j++) {
                    keys.add(buckets[i].get(j).key);
                }
            }
            return keys;
        }

        public int size() {
            return n;
        }

    }

    public static void main(String[] args) {
        HashMap<String, Integer> map = new HashMap<>();
        map.put("India", 120);
        map.put("US", 30);
        map.put("China", 150);
        map.put("India", 130); // Update value for existing key

        System.out.println(map.containsKey("Ruqsana"));
        System.out.println(map.isEmpty());
        System.out.println(map.size());
        System.out.println(map.keySet());
        System.out.println(map.remove("US"));
        System.out.println(map.size());
        System.out.println(map.keySet());
        System.out.println(map.get("India"));
    }

}

package hashing;

import java.util.ArrayList;
import java.util.LinkedList;

public class HashMapImplementation {

    static class HashMap<K, V> {
        public class Node {
            K key;
            V value;

            public Node(K key, V value) {
                this.key = key;
                this.value = value;
            }
        }

        private int n; // no of nodes
        private int N; // buckets / buckets.length
        private LinkedList<Node>[] buckets;

        public HashMap() {
            this.N = 4;
            buckets = new LinkedList[4];
            for (int i = 0; i < N; i++) {
                buckets[i] = new LinkedList<>();
            }
        }

        private int hashFunction(K key) {
            int hi = key.hashCode(); //0 to N-1
            return Math.abs(hi) % N;
        }

        private int searchInLL(K key, int bi) {
            LinkedList<Node> ll = buckets[bi];
            for (int j = 0; j < ll.size(); j++) {
                if (buckets[bi].get(j).key == key)
                    return j;
            }
            return -1;
        }

        public void rehashing() {
            LinkedList<Node>[] oldBucket = buckets;
            buckets = new LinkedList[2 * N];

            for (int i = 0; i < 2 * N; i++) {
                buckets[i] = new LinkedList<>();
            }

            for (LinkedList<Node> node : oldBucket) {
                for (Node j : node) {
                    put(j.key, j.value);
                }
            }

        }

        public void put(K key, V value) {
            int bi = hashFunction(key);
            int di = searchInLL(key, bi);
            if (di == -1) {
                buckets[bi].add(new Node(key, value));
                n++;
            } else {
                Node data = buckets[bi].get(di);
                data.value = value;
            }

            int lambda = n / N;
            if (lambda > 2.0) {
                rehashing();
            }
        }

        public boolean containsKey(K key) {
            int bi = hashFunction(key);
            int di = searchInLL(key, bi);
            return di != -1;
        }

        public V remove(K key) {
            int bi = hashFunction(key);
            int di = searchInLL(key, bi);
            if (di != -1) {
                Node data = buckets[bi].remove(di);
                n--;
                return data.value;
            }
            return null;
        }

        public V get(K key) {
            int bi = hashFunction(key);
            int di = searchInLL(key, bi);
            if (di == -1) {
                return null;
            } else {
                Node data = buckets[bi].get(di);
                return data.value;
            }
        }

        public ArrayList<K> keySet() {
            ArrayList<K> keySet = new ArrayList<>();
            for (LinkedList<Node> nodes : buckets) {
                for (Node node : nodes) {
                    keySet.add(node.key);
                }
            }
            return keySet;
        }

        public boolean isEmpty() {
            return n == 0;
        }

    }

    public static void main(String[] args) {
        HashMap<String, Integer> map = new HashMap<>();
        map.put("India", 120);
        map.put("US", 30);
        map.put("China", 150);

        ArrayList<String> keys = map.keySet();
        for (String key : keys) {
            System.out.println(key + " " + map.get(key));
        }

        System.out.println(map.keySet());
        System.out.println(map.remove("India"));
        System.out.println(map.isEmpty());
        System.out.println(map.containsKey("Dubai"));
    }
}

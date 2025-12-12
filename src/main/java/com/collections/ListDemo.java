package com.collections;

import java.util.*;

public class ListDemo extends CollectionBase {

    public void arrayListMethods() {
        List<Integer> list = new ArrayList<>();
        collectionMethods(list, 1, 2, 3);

        //CREATE
        List<String> list1 = Arrays.asList("Dog", "Apple", "Ball", "Cat");
        String[] array = {"X", "Y", "Z"};
        List<String> arrayToList = Arrays.asList(array);
        List<String> list2 = List.of("A", "B", "C");
        List<String> modifiableList = new ArrayList<>(arrayToList);

        //ADD at specific index
        modifiableList.add(1, "Ruqsana");

        //RETRIEVE
        list2.get(2);
        list.indexOf(10);
        list.lastIndexOf(10);

        //UPDATE
        list.set(0, 20); //Returns previous element
        modifiableList.subList(1, 3);

        //REMOVE
        list.remove(1); //by index
        list.remove(Integer.valueOf(0)); //by value
        modifiableList.remove("X");
        modifiableList.removeIf(s -> s.startsWith("Y"));

        //SORTING
        Collections.sort(list);
        list1.sort(Comparator.naturalOrder());
        list1.sort(Comparator.reverseOrder());
        list1.sort(Comparator.comparing(String::length));

        //TO ARRAY
        list1.toArray();

    }

    public void linkedListMethods() {
        List<Integer> linkedList = new LinkedList<>();
        collectionMethods(linkedList, 5, 10, 15);

        //CREATE
        LinkedList<String> ll = new LinkedList<>(Arrays.asList("Red", "Green", "Blue", ""));

        //ADD at beginning and end
        ll.addFirst("Yellow");
        ll.addLast("Purple");

        //RETRIEVE first and last
        ll.getFirst();
        ll.getLast();

        //REMOVE first and last
        ll.removeFirst();
        ll.removeLast();
        ll.removeIf(String::isEmpty);

        //PEEK and POLL
        ll.peek(); // Retrieves first element without removing
        ll.poll(); // Retrieves and removes first element
    }
}

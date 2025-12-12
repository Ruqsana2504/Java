package com.collections;

import java.util.Collection;
import java.util.List;

public class CollectionBase {

    public <T> void collectionMethods(Collection<T> collection, T sampleElement, T anotherElement, T yetAnotherElement) {
        System.out.println("Initial collection: " + collection);

        //ADD
        collection.add(sampleElement);
        collection.addAll(List.of(sampleElement, anotherElement));

        //Retrieve
        collection.size();
        collection.isEmpty();
        collection.contains(anotherElement);
        collection.containsAll(List.of(anotherElement, yetAnotherElement));

        //Remove
        collection.remove(anotherElement);
        collection.removeAll(List.of(anotherElement)); // Remove all specified elements
        collection.retainAll(List.of(sampleElement)); // Retain only specified elements
        collection.clear();

        collection.iterator();
        collection.toArray();
        System.out.println("Final collection: " + collection);
    }
}

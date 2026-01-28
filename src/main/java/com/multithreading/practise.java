package com.multithreading;

public class practise {

    boolean hasData = false;

    public synchronized void produce() {
        System.out.println("Producing Data");
        hasData = true;
        System.out.println("Added successfully");
        notify();
    }

    public synchronized void consume() {
        while (!hasData) {
            try {
                System.out.println("Waiting for producer to produce data : " + Thread.currentThread().getName());
                wait();
            } catch (Exception e) {
                Thread.currentThread().interrupt();
            }
        }
        System.out.println("Consuming Data");
        hasData = false;
        notify();
    }

    static void main() {
        practise pc = new practise();

        Thread producerThread = new Thread(() -> {
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
            pc.produce();
        }, "producerThread");

        Thread consumerThread = new Thread(pc::consume, "consumerThread");

        producerThread.start();
        consumerThread.start();

        try {
            producerThread.join();
            consumerThread.join();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        System.out.println("Main Thread...");
    }
}

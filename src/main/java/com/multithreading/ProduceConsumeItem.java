package com.multithreading;

class ProduceConsumeItem {

    boolean itemAvailable = false;

    public synchronized void addItem() {
        System.out.println("Adding item");
        itemAvailable = true;
        System.out.println("Added successfully");
        notify();
    }

    public synchronized void consumeItem() {
        if (!itemAvailable) {
            try {
                System.out.println("Waiting for item to be added");
                wait();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
        System.out.println("Consumed successfully");
        itemAvailable = false;
        notify();
    }

    static void main() {
        ProduceConsumeItem produceConsume = new ProduceConsumeItem();

        Thread producer = new Thread(() -> {
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
            produceConsume.addItem();
        });

        Thread consumer = new Thread(() -> produceConsume.consumeItem());

        producer.start();
        consumer.start();

        try {
            producer.join();
            consumer.join();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        System.out.println("Main Thread...");

    }
}

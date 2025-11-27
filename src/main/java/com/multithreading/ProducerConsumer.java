package com.multithreading;

import java.util.LinkedList;
import java.util.Queue;

class ProducerConsumer {

    Queue<Integer> q;
    int size;

    public ProducerConsumer(Queue<Integer> q, int size) {
        this.q = q;
        this.size = size;
    }

    public synchronized void produce() {
        for (int i = 1; i <= 10; i++) {
            while (q.size() == size) {
                try {
                    System.out.println("Waiting for the consumer to consume ");
                    wait();
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
            q.add(i);
            System.out.println("Produced : " + i);
            notify();
        }
    }

    public synchronized void consume() {
        for (int i = 1; i <= 10; i++) {
            while (q.isEmpty()) {
                try {
                    System.out.println("Waiting for the producer to produce ");
                    wait();
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
            System.out.println("Consumed : " + q.poll());
            notify();
        }
    }

    static void main() {
        Queue<Integer> q = new LinkedList<>();
        ProducerConsumer producerConsumer = new ProducerConsumer(q, 3);

        Thread producerThread = new Thread(() -> producerConsumer.produce(), "ProducerThread");
        Thread consumerThread = new Thread(() -> producerConsumer.consume(), "ConsumerThread");

        producerThread.start();
        consumerThread.start();

    }
}

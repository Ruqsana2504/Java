package com.mphasis;

public class ThreadDemo {

    //print numbers from 1 to 10 using two threads:
    //Thread-1 prints odd numbers
    //Thread-2 prints even numbers
    //Output must be in order

    static int number = 1;
    static final int limit = 10;
    static final Object obj = new Object();

    static void main() {

        Thread oddThread = new Thread(() -> {
            while (number <= limit) {
                synchronized (obj) {
                    if (number % 2 == 0) {
                        try {
                            obj.wait();
                        } catch (InterruptedException e) {
                            Thread.currentThread().interrupt();
                        }
                    } else {
                        System.out.println(number);
                        number++;
                        obj.notify();
                    }
                }
            }
        });

        Thread evenThread = new Thread(() -> {
            while (number <= limit) {
                synchronized (obj) {
                    if (number % 2 != 0) {
                        try {
                            obj.wait();
                        } catch (InterruptedException e) {
                            Thread.currentThread().interrupt();
                        }
                    } else {
                        System.out.println(number);
                        number++;
                        obj.notify();
                    }
                }
            }
        });

        oddThread.start();
        evenThread.start();

    }

}

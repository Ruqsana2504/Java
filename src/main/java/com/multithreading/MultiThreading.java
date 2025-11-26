package com.multithreading;

public class MultiThreading {
    static void main() {
//        System.out.println(Thread.currentThread()); //Thread[main,5,main]
//        System.out.println(Thread.currentThread().getName()); //main
//        System.out.println(Thread.currentThread().getState()); //RUNNABLE

        BankAccount account = new BankAccount();
        Thread t1 = new Thread(() -> account.withdraw(50), "Hulk");
        Thread t2 = new Thread(() -> account.withdraw(50), "Thor");
        t1.start();
        t2.start();
        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            t1.interrupt();
        }

//        Counter counter = new Counter();
//        Thread t1 = new Thread(() -> {
//            for (int i = 0; i < 1000; i++)
//                counter.increment();
//        });
//        Thread t2 = new Thread(() -> {
//            for (int i = 0; i < 1000; i++)
//                counter.increment();
//        });
//
//        t1.start();
//        t2.start();
//
//        try {
//            t1.join();
//            t2.join();
//        } catch (InterruptedException e) {
//            t1.interrupt();
//        }
//
//        System.out.println(counter.getCount());
    }

}

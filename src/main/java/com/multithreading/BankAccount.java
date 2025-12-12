package com.multithreading;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class BankAccount {

    private int balance = 100;

    private final Lock lock = new ReentrantLock();

    public void withdraw(int amount) {//not using synchronized - using explicit locks
        System.out.println(Thread.currentThread().getName() + " Attempting to withdraw " + amount + " from account with balance " + balance);
        try {
            if (lock.tryLock()) { //acquires lock if free and returns true else returns false
                if (amount <= balance) {
                    try {
                        System.out.println(Thread.currentThread().getName() + " Proceeding with withdrawal " + amount);
                        Thread.sleep(3000);
                        balance -= amount;
                        System.out.println(Thread.currentThread().getName() + " Withdrawal completed " + balance);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    } finally {
                        lock.unlock();
                    }
                } else {
                    System.out.println("Insufficient balance for " + Thread.currentThread().getName());
                }
            } else {
                System.out.println(Thread.currentThread().getName() + " Could not acquire lock, will try later.");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

//    public synchronized void withdraw(int amount) {
//        System.out.println(Thread.currentThread().getName() + " Attempting to withdraw " + amount + " from account with balance " + balance);
//        if (amount <= balance) {
//            System.out.println(Thread.currentThread().getName() + " Proceeding with withdrawal " + amount);
//            try {
//                Thread.sleep(10000);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//            balance -= amount;
//            System.out.println(Thread.currentThread().getName() + " Withdrawal completed " + balance);
//        } else {
//            System.out.println("Insufficient balance for " + Thread.currentThread().getName());
//        }
//    }
}

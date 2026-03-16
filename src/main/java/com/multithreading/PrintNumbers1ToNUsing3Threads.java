package com.multithreading;

public class PrintNumbers1ToNUsing3Threads {
    int counter = 1;
    int N;

    public PrintNumbers1ToNUsing3Threads(int N) {
        this.N = N;
    }

    public synchronized void print(int remainder) {
        while (counter <= N) {
            //If you are not the correct thread wait
            while (counter % 3 != remainder && counter <= N) {
                try {
                    wait();
                } catch (InterruptedException e) {
                    //Do Nothing
                }
            }

            //else print and notifyAll to try again
            if (counter <= N) {
                System.out.println(counter + " " + Thread.currentThread().getName());
                counter++;
                notifyAll();
            }

        }
    }


    static void main() {
        int N = 10;
        PrintNumbers1ToNUsing3Threads printNumbers1ToNUsing3Threads = new PrintNumbers1ToNUsing3Threads(N);

        Thread t1 = new Thread(() -> printNumbers1ToNUsing3Threads.print(1));
        Thread t2 = new Thread(() -> printNumbers1ToNUsing3Threads.print(2));
        Thread t3 = new Thread(() -> printNumbers1ToNUsing3Threads.print(0));

        t1.start();
        t2.start();
        t3.start();
    }
}

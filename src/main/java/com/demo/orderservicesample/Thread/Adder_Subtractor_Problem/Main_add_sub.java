package com.demo.orderservicesample.Thread.Adder_Subtractor_Problem;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Main_add_sub {
    public static void main(String[] args) throws InterruptedException {
        Lock lock = new ReentrantLock();
        ExecutorService Es = Executors.newFixedThreadPool(2);

        Count count = new Count();
        Adder adder = new Adder(count, lock);
        Subtractor subtractor = new Subtractor(count, lock);

        Thread t1 = new Thread(adder);
        Thread t2 = new Thread(subtractor);

        t1.start();
        t2.start();

        t1.join();// Main thread will wait for t1 to complete
        t2.join();// main thread will wait for t2 to complete


        System.out.println("Final value : " + count.num);

    }
}

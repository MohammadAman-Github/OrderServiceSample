package com.demo.orderservicesample.Thread.ThreadPool;

public class NumberPrinter implements Runnable {

    @Override
    public void run() {
        System.out.println("Starting a new thread");
        int i = 0;
        for (i = 0; i < 100; i++) {
            System.out.println(i+ " " + Thread.currentThread().getName());
        }
    }
}

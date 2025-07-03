package com.demo.orderservicesample.Thread;

public class OddThread implements Runnable {
    @Override
    public void run() {
        int i = 0;
        for (i = 0; i < 100; i++) {
            if(i % 2 != 0) {
                System.out.println("OddThread: " + i);
            }
        }
    }
}

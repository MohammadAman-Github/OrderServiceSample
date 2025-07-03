package com.demo.orderservicesample.Thread.Adder_Subtractor_Problem;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Subtractor implements Runnable {

    Count count;
    Lock lock;

    public Subtractor(Count count, Lock lock) {
        this.count = count;
        this.lock = lock;
    }

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            lock.lock();
            count.num--;
            lock.unlock();
        }
        System.out.println("End of Subtractor");
    }
}

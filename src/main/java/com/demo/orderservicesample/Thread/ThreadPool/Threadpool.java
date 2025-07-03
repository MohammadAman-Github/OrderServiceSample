package com.demo.orderservicesample.Thread.ThreadPool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Threadpool {
    public static void main(String[] args) {
        NumberPrinter numberPrinter = new NumberPrinter();

        //Thread NP = new Thread(numberPrinter);
        //NP.start();

        ExecutorService Es = Executors.newFixedThreadPool(2);// this line create the thread pool
        for (int i = 0; i < 5; i++) {
            //Es.submit(numberPrinter);
            Es.execute(numberPrinter);
        }
        Es.shutdown();// thread will not automatically shutdown so we have to shutdown this by writting this line
    }
}

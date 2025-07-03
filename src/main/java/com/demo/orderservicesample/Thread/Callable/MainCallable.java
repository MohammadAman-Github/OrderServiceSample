package com.demo.orderservicesample.Thread.Callable;

import java.util.concurrent.*;

public class MainCallable {
    public static void main(String[] args) throws ExecutionException, InterruptedException, TimeoutException {
        ExecutorService ES = Executors.newFixedThreadPool(1);

        RandomNumberGenerator RNG = new RandomNumberGenerator();
         Future<Integer> fi =  ES.submit(RNG);
        System.out.println("Main doing own task");
        int randomNumber = fi.get(5, TimeUnit.SECONDS);
        System.out.println( "RN :" + randomNumber );
        ES.shutdown();
    }
}

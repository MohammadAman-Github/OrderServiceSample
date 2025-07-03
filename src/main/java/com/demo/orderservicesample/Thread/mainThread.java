package com.demo.orderservicesample.Thread;

public class mainThread {
    public static void main(String[] args) {
        EvenThread evenThread = new EvenThread();
        OddThread oddThread = new OddThread();

        Thread EvT = new Thread(evenThread);
        Thread OdT = new Thread(oddThread);
        EvT.start();
        OdT.start();
    }
}

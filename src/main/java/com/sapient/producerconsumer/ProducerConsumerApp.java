package com.sapient.producerconsumer;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class ProducerConsumerApp {
    public static void main(String[] args) {
        BlockingQueue<Integer> sharedQueue = new LinkedBlockingQueue<>();

        Producer p = new Producer(sharedQueue);
        Consumer c = new Consumer(sharedQueue);
        p.start();
        c.start();
    }
}

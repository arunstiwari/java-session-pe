package com.sapient.producerconsumer;

import java.util.concurrent.BlockingQueue;

public class Producer extends Thread{
    private BlockingQueue<Integer> sharedQueue;

    public Producer(BlockingQueue<Integer> sharedQueue) {
        this.sharedQueue = sharedQueue;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10 ; i++) {
            try {
                System.out.println(getName() + " produced "+ i);
                this.sharedQueue.put(i);
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

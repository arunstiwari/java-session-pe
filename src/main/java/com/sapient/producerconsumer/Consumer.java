package com.sapient.producerconsumer;

import java.util.concurrent.BlockingQueue;

public class Consumer extends  Thread{
    private BlockingQueue<Integer> sharedQueue;

    public Consumer(BlockingQueue<Integer> sharedQueue) {
        this.sharedQueue = sharedQueue;
    }

    @Override
    public void run() {
        while (true){
            try {
                Integer number = this.sharedQueue.take();
                System.out.println(getName()+ " Consumed item :"+number);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

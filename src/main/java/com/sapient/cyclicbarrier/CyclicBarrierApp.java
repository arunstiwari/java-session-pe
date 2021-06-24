package com.sapient.cyclicbarrier;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class CyclicBarrierApp {
    public static void main(String[] args) {
        CyclicBarrier cyclicBarrier = new CyclicBarrier(3);

        System.out.println("Initial value of Product and sum = "+ Computation1.product + " ---"+Computation2.sum);

        Computation1 computation1 = new Computation1(cyclicBarrier);
        Computation2 computation2 = new Computation2(cyclicBarrier);

        Thread t1 = new Thread(computation1);
        Thread t2 = new Thread(computation2);
        t1.start();
        t2.start();

        try {
            cyclicBarrier.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (BrokenBarrierException e) {
            e.printStackTrace();
        }
        System.out.println("Final value of Product and sum = "+ Computation1.product + " ---"+Computation2.sum);


    }
}

package com.sapient.cyclicbarrier;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class Computation1 implements Runnable {
    public static int product = 0;
    private CyclicBarrier cyclicBarrier;

    public Computation1(CyclicBarrier cyclicBarrier) {
        this.cyclicBarrier = cyclicBarrier;
    }


    @Override
    public void run() {
        product = 2 * 3;
        try {
            cyclicBarrier.await(3000, TimeUnit.MILLISECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (BrokenBarrierException e) {
            e.printStackTrace();
        } catch (TimeoutException e) {
            e.printStackTrace();
        }
    }
}

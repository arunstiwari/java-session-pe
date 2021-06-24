package com.sapient.cyclicbarrier;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class Computation2  implements  Runnable{
    public static int sum = 0;
    private CyclicBarrier cyclicBarrier;

    public Computation2(CyclicBarrier cyclicBarrier) {
        this.cyclicBarrier = cyclicBarrier;
    }

    @Override
    public void run() {
        sum = 10 + 20;
        try {
            cyclicBarrier.await(3000, TimeUnit.MILLISECONDS);
            System.out.println("Number of parties waiting at the barrier at this point = "+cyclicBarrier.getNumberWaiting());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (BrokenBarrierException e) {
            e.printStackTrace();
        } catch (TimeoutException e) {
            e.printStackTrace();
        }
    }
}

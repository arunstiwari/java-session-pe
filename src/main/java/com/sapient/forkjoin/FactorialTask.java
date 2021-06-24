package com.sapient.forkjoin;

import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.RecursiveTask;

public class FactorialTask extends RecursiveTask<Double> {
    private long start;
    private long end;

    public FactorialTask(long end ) {
        this(1,end);
    }

    public FactorialTask(long start, long end) {
        this.start = start;
        this.end = end;
    }

    @Override
    protected Double compute() {
        long length = (end - start + 1);
        if (length <= 5){
            //do some compuation
            return factorial();
        }

        long mid = length /2 ;
        FactorialTask firstTask = new FactorialTask(start, start+mid);
        FactorialTask secondTask = new FactorialTask(start+mid+1, end);
        firstTask.fork();

        return secondTask.compute() * firstTask.join();
    }

    private Double factorial() {
       double result = 1.0;
        for (long i = start; i < end; i++) {
            result *=i;
        }
        return  result;
    }
}


package com.sapient.forkjoin;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;

import static java.util.concurrent.ForkJoinPool.commonPool;

public class ForkJoinApp {
    public static void main(String[] args) {
        ForkJoinTask facotrialTask = new FactorialTask(100);
        System.out.println(commonPool().invoke(facotrialTask));

        List<String> names = Arrays.asList("ABC", "CDE");
    }
}

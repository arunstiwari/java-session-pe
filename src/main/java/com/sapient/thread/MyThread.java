package com.sapient.thread;

public class MyThread implements  Runnable{

    @Override
    public void run() {
        System.out.println("MyThread class run method");
        try {
            Thread.sleep(200);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("MyThread is finished");
    }
}

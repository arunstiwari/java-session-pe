package com.sapient.countdownlatch;

import java.util.concurrent.CountDownLatch;

public class VideoConference implements  Runnable {
    private  final CountDownLatch controller;

    public VideoConference(int number) {
        this.controller = new CountDownLatch(number);
    }

    public void arrive(String name){
        System.out.println("Participant with name = " + name + " joined");
        controller.countDown();
        System.out.println("Waiting for still  "+controller.getCount() + " participants");
    }

    @Override
    public void run() {
        System.out.println("Videoconference: Initialization of participants with count: "+controller.getCount());

        try {
            controller.await();
            System.out.println("All participants have arrived now");
            System.out.println("Let us start our video conference");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

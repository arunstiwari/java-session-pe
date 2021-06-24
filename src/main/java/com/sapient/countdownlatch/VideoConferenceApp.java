package com.sapient.countdownlatch;

public class VideoConferenceApp {
    public static void main(String[] args) {
        VideoConference videoConference = new VideoConference(20);

        Thread threadConference = new Thread(videoConference);
        threadConference.start();

        for (int i = 0; i <20 ; i++) {
            Participant p = new Participant(videoConference, "Participant"+i);
            Thread t = new Thread(p);
            t.start();
        }
    }
}

package com.sapient.observer;

public class ObserverSimulator {
    public static void main(String[] args) {
        // Data Subject
        //Observer observing the subject
        SimpleSubject simpleSubject = new SimpleSubject();

        SimpleObserver observer = new SimpleObserver(simpleSubject);
        simpleSubject.setValue(45);

    }
}

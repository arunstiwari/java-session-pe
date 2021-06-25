package com.sapient.observer;

public class ObserverSimulator {
    public static void main(String[] args) {
        // Data Subject
        //Observer observing the subject
        SimpleSubject simpleSubject = new SimpleSubject();

        SimpleObserver observer = new SimpleObserver("observer1");
        simpleSubject.addPropertyChangeListener(observer);
        SimpleObserver observer1 = new SimpleObserver("observer2");
        simpleSubject.addPropertyChangeListener(observer1);
        simpleSubject.setValue(45);

        simpleSubject.setValue(55);

//        System.out.println(observer.getValue());

    }
}

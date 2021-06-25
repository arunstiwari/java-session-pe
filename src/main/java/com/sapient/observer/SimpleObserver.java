package com.sapient.observer;

import java.util.Observable;
import java.util.Observer;

public class SimpleObserver implements Observer {
    private int value;
    private Observable observable;

    public SimpleObserver(Observable observable) {
        this.observable = observable;
    }



    @Override
    public void update(Observable o, Object arg) {
        System.out.println("arg = " + arg);

        this.value = (int) arg;
        System.out.println("The new value : "+this.value);
        if ( o instanceof SimpleSubject){
            SimpleSubject simpleSubject = (SimpleSubject) o;
            System.out.println(simpleSubject.getValue());
        }

    }
}

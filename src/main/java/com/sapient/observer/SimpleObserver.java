package com.sapient.observer;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.Observable;

public class SimpleObserver implements PropertyChangeListener {
    private int value;
    private String name;

    public SimpleObserver(String name) {
        this.name = name;
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        this.value = (int) evt.getNewValue();
        System.out.println(name+ " New event occured ---"+this.value);
    }

    public int getValue() {
        return value;
    }
}

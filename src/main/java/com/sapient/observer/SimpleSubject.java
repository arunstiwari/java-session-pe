package com.sapient.observer;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class SimpleSubject {
    private int value=0;
    private PropertyChangeSupport support;

    public SimpleSubject(){
        this.support = new PropertyChangeSupport(this);
    }

    public void addPropertyChangeListener(PropertyChangeListener pcl) {
        support.addPropertyChangeListener(pcl);
    }

    public void removePropertyChangeListener(PropertyChangeListener pcl) {
        support.removePropertyChangeListener(pcl);
    }

    public void setValue(int value) {
        support.firePropertyChange("value", this.value, value);
        this.value = value;
    }


    public int getValue() {
        return value;
    }
}

package com.sapient.factory;

import java.util.Collection;

public class GenericFactory<T,F> {
    Class theClass;

    public GenericFactory(Class theClass) {
        this.theClass = theClass;
    }

    public T createInstance() throws InstantiationException, IllegalAccessException {
        return (T)this.theClass.newInstance();
    }

}

package com.sapient.forkjoin;

import java.util.concurrent.Callable;

public class Computation implements Callable {
    @Override
    public Object call() throws Exception {
        return 123;
    }
}

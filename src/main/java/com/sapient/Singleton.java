package com.sapient;

import java.io.BufferedReader;

public class Singleton {
//    private  Singleton uniqueInstance;
    private int number =0;
    private Singleton(){}

//    public  synchronized Singleton getInstance(){
//        if (uniqueInstance == null){
//            uniqueInstance = new Singleton();
//        }
//
//        return uniqueInstance;
//    }

    public int getNumber(){
        return this.number;
    }

    public void setNumber(int number){
        this.number = number;
    }

}

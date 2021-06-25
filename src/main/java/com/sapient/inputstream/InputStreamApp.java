package com.sapient.inputstream;

import java.io.*;

public class InputStreamApp {

    public static void main(String[] args) throws IOException {
        InputStream inputStream = new BufferedInputStream(new FileInputStream("/Users/arunstiwari/training/pe/session-java-1/.gitignore"));
        int data = inputStream.read();
        while (data !=-1){
            data = inputStream.read();
            System.out.println("data = " + (char)data);
        }

        inputStream.close();
    }
}

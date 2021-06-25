package com.sapient.inputstream;

import java.io.*;

public class OutstreamApp {

    public static void main(String[] args) throws IOException {
        OutputStream outputStream = new FileOutputStream("/Users/arunstiwari/training/pe/session-java-1/dummy.txt");
        outputStream.write("This is IO session".getBytes());
        outputStream.close();


    }
}

// Stream/Reader
// InputStream/InputReader
// OutputStream/OutputReader
// program it reads the data into stream/reader first -> do some computation with data which has been read -> destination
// program write the data to stream/reader -> stream/reader then write the data to external things files/network socket

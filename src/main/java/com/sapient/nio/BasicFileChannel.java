package com.sapient.nio;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class BasicFileChannel {

    public void readContentOfAGivenFile(String filename) throws IOException {
        RandomAccessFile randomAccessFile = new RandomAccessFile(filename, "rw");
        FileChannel channel = randomAccessFile.getChannel();

        ByteBuffer buffer = ByteBuffer.allocate(48);
        int read = channel.read(buffer);

        while (read != -1){
//            System.out.println("read = " + read);
          //  System.out.println("read = " + (char)read);
            buffer.flip();

            while (buffer.hasRemaining()){
                System.out.println("(char)read = " + (char)buffer.get());
            }

            buffer.clear();
            read = channel.read(buffer);
        }

        randomAccessFile.close();


    }

    public static void main(String[] args) throws IOException {
        BasicFileChannel app = new BasicFileChannel();
        app.readContentOfAGivenFile("/Users/arunstiwari/training/pe/session-java-1/.gitignore");

    }
}

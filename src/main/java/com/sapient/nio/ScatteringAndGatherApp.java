package com.sapient.nio;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.Channels;
import java.nio.channels.GatheringByteChannel;
import java.nio.channels.ScatteringByteChannel;

public class ScatteringAndGatherApp {
    public static void main(String[] args) throws IOException {
        FileInputStream fileInputStream = new FileInputStream("/Users/arunstiwari/training/pe/session-java-1/src/main/resources/data1.txt");
        ScatteringByteChannel inChannel = (ScatteringByteChannel) Channels.newChannel(fileInputStream);

        ByteBuffer byteBuffer1 = ByteBuffer.allocate(100);
        ByteBuffer byteBuffer2 = ByteBuffer.allocate(100);
        ByteBuffer byteBuffer3 = ByteBuffer.allocate(100);

        ByteBuffer[] bufferArray = {byteBuffer1, byteBuffer2, byteBuffer3};

        inChannel.read(bufferArray);
        byteBuffer1.flip();
        byteBuffer2.flip();
        byteBuffer3.flip();

        int i = 0;
        while (i < bufferArray.length){
            while (bufferArray[i].hasRemaining()){
                System.out.println((char)bufferArray[i].get()+ " ");
            }
            System.out.println();
            i++;
        }

        byteBuffer1.rewind();
        byteBuffer2.rewind();
        byteBuffer3.rewind();

        FileOutputStream fos = new FileOutputStream("data2.txt");
        GatheringByteChannel destChannel = (GatheringByteChannel) Channels.newChannel(fos);
        destChannel.write(bufferArray);
        inChannel.close();
        destChannel.close();
    }
}

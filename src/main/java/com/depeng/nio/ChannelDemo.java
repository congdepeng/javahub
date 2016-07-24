package com.depeng.nio;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class ChannelDemo {

    public static void main(String[] args) throws IOException {
        String current = new java.io.File(".").getCanonicalPath();
        System.out.println("Current dir:" + current);
        String currentDir = System.getProperty("user.dir");
        System.out.println("Current dir using System:" + currentDir);


        File file = new File("");
        //我们无法直接打开一个FileChannel，需要通过使用一个InputStream、OutputStream或RandomAccessFile来获取一个FileChannel实例
        //FileInputStream fileInputStream = new FileInputStream(file);
        //FileChannel channel1 = fileInputStream.getChannel();


        RandomAccessFile randomAccessFile = new RandomAccessFile("settings.gradle", "rw");
        FileChannel channel = randomAccessFile.getChannel();
        ByteBuffer byteBuffer = ByteBuffer.allocate(10);

        //The number of bytes read, possibly zero, or <tt>-1</tt> if the channel has reached end - of-stream
        int readByteNumber = channel.read(byteBuffer);
        while (readByteNumber != -1) {
            System.out.println();
            System.out.println(" - read - "+readByteNumber);
            
            // transaction start
            //开始读缓冲的时候 flip
            byteBuffer.flip();
            System.out.print("^");
            while (byteBuffer.hasRemaining()) {
                System.out.print((char) byteBuffer.get());
            }
            System.out.print("$");
            byteBuffer.clear();
            //读完以后 clear
            //transaction end
            
            
            readByteNumber = channel.read(byteBuffer);
        }

        randomAccessFile.close();

    }

}

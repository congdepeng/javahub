package depeng.nio;

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


        RandomAccessFile file = new RandomAccessFile("build.gradle", "rw");
        FileChannel channel = file.getChannel();
        ByteBuffer byteBuffer = ByteBuffer.allocate(10);
        
        int read = channel.read(byteBuffer);
        while (read != -1) {
            System.out.println();
            System.out.println(" - read - "+read);
            byteBuffer.flip();
            System.out.print("^");
            while (byteBuffer.hasRemaining()) {
                System.out.print((char) byteBuffer.get());
            }
            System.out.print("$");
            byteBuffer.clear();
            read = channel.read(byteBuffer);
        }

        file.close();

    }

}

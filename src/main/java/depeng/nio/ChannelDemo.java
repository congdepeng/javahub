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


        RandomAccessFile file = new RandomAccessFile("settings.gradle", "rw");
        FileChannel channel = file.getChannel();
        ByteBuffer byteBuffer = ByteBuffer.allocate(10);

        //The number of bytes read, possibly zero, or <tt>-1</tt> if the channel has reached end - of-stream
        int readByteNumber = channel.read(byteBuffer);
        while (readByteNumber != -1) {
            System.out.println();
            System.out.println(" - read - "+readByteNumber);
            byteBuffer.flip();
            System.out.print("^");
            while (byteBuffer.hasRemaining()) {
                System.out.print((char) byteBuffer.get());
            }
            System.out.print("$");
            byteBuffer.clear();
            readByteNumber = channel.read(byteBuffer);
        }

        file.close();

    }

}

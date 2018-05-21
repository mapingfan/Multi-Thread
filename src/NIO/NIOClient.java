package NIO;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.net.InetSocketAddress;
import java.nio.channels.FileChannel;
import java.nio.channels.SocketChannel;

public class NIOClient {
    public static void main(String[] args) throws IOException {
        SocketChannel sc = SocketChannel.open();
        InetSocketAddress is = new InetSocketAddress(8888);
        sc.connect(is);

        RandomAccessFile ra = new RandomAccessFile(NIOClient.class.getClassLoader().getResource("test.txt").getFile(), "rw");
        FileChannel fc = ra.getChannel();
        fc.transferTo(0, fc.size(), sc);
        fc.close();
        sc.close();
        ra.close();
    }
}

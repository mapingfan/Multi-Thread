package NIO;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.*;
import java.util.Iterator;
import java.util.Set;

public class Reactor {
    public static void main(String[] args) throws IOException {
        Selector selector = Selector.open();
        ServerSocketChannel ssc = ServerSocketChannel.open();
        ssc.bind(new InetSocketAddress(1234));
        ssc.configureBlocking(false); //配置非阻塞.
        ssc.register(selector, SelectionKey.OP_ACCEPT);

        while (selector.select() > 0) {
            Set<SelectionKey> selectionKeys = selector.selectedKeys();
            Iterator<SelectionKey> iterator = selectionKeys.iterator();
            while (iterator.hasNext()) {
                SelectionKey key = iterator.next();
                iterator.remove();
                if (key.isAcceptable()) {
                    ServerSocketChannel acceptChannel = (ServerSocketChannel) key.channel();
                    SocketChannel socketChannel = acceptChannel.accept();
                    socketChannel.configureBlocking(false);
                    System.out.println("Accept connection request from " + socketChannel.getRemoteAddress());
                    socketChannel.register(selector, SelectionKey.OP_READ);
                } else if (key.isReadable()) {
                    SocketChannel channel = (SocketChannel) key.channel();
                    ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
                    int count = channel.read(byteBuffer)        ;
                    if (count <= 0) {
                        channel.close();
                        key.cancel();
                        continue;
                    }
                    System.out.println("Receive message from " + channel.getRemoteAddress());
                }
                selectionKeys.remove(key);
            }
        }

    }
}

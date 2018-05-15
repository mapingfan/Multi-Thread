package D8.JUC.Exchanger;

import java.util.concurrent.Exchanger;

/**
 * juc包的exchanger示例.
 * 用于让两个线程安全的交换对象.
 * 这个地方的交换是什么意思?是两个线程交换彼此的对象,还是一个对象在两个线程之间传递.
 * 根据意思是有两个对象的.彼此持有彼此的对象.
 */
public class Main {

    public static void main(String[] args) {
        Exchanger<char[]> exchanger = new Exchanger<>();
        char[] buffer1 = new char[10];
        char[] buffer2 = new char[10];
        //交换后,buffer1的内容会传递给buffer2.
        new ProducerThread(exchanger, buffer1, 314159L).start();
        new ConsumerThread(exchanger, buffer2, 26538L).start();
    }
}

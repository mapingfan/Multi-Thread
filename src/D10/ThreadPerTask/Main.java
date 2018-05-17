package D10.ThreadPerTask;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;

/**
 * 对于每个任务,开启一个线程执行.
 */
public class Main {
    public static void main(String[] args) {
        System.out.println("Task begin");
        ThreadFactory factory = Executors.defaultThreadFactory();
        ExecutorService executorService = Executors.newCachedThreadPool();
        Host host = new Host(factory, executorService);
        try {

            host.request(10, 'A');
            host.request(20, 'B');
            host.request(30, 'C');
        } finally {
            executorService.shutdown();
            System.out.println("Task end");
        }

    }
}


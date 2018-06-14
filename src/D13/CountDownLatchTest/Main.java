package D13.CountDownLatchTest;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    public static void main(String[] args) {
        System.out.println("BEGIN");
        int tasks = 10;
        ExecutorService es = Executors.newFixedThreadPool(5);
        CountDownLatch cdl = new CountDownLatch(tasks); //等待5个线程全部执行完毕.
        try {
            for (int i = 0; i < tasks; i++) {
                es.execute(new MyTask(cdl, i));
            }
            cdl.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            es.shutdown();
        }
        System.out.println("END");
    }
}

package D13.CyclicBarrierTest;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    public static final int THREADS = 3;

    public static void main(String[] args) {
        System.out.println("BEGIN");
        System.out.println("AWAIT");

        ExecutorService es = Executors.newFixedThreadPool(THREADS);
        CountDownLatch cdl = new CountDownLatch(THREADS);
        CyclicBarrier cb = new CyclicBarrier(THREADS, () -> System.out.println("Barrier Action"));
        try {
            for (int i = 0; i < THREADS; i++) {
                es.execute(new MyTask(cdl, cb, i));
            }
            cdl.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            es.shutdown();
            System.out.println("END");
        }


    }
}

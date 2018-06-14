package D13.CyclicBarrierTest;

import java.util.Random;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.CyclicBarrier;

public class MyTask implements Runnable {

    private CountDownLatch cdl;
    private CyclicBarrier cb;
    private int context;

    public MyTask(CountDownLatch cdl, CyclicBarrier cb, int context) {
        this.cdl = cdl;
        this.cb = cb;
        this.context = context;
    }

    @Override
    public void run() {
        try {
            for (int i = 0; i < 5; i++) {
                doTask(i);
                cb.await();
            }
            cdl.countDown();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (BrokenBarrierException e) {
            e.printStackTrace();
        } finally {

        }
    }

    static Random random = new Random();

    private void doTask(int phase) {
        System.out.println(Thread.currentThread().getName() + ":MyTask:BEGIN:context = " + context + ", phase = " + phase);
        context++;
        try {
            Thread.sleep(random.nextInt(500));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

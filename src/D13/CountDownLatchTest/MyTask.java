package D13.CountDownLatchTest;

import java.util.Random;
import java.util.concurrent.CountDownLatch;

public class MyTask implements Runnable {
    private CountDownLatch cdl;
    private int context;

    public MyTask(CountDownLatch cdl, int context) {
        this.cdl = cdl;
        this.context = context;
    }

    @Override
    public void run() {
        doTask();
        cdl.countDown();
    }

    public static Random random = new Random();
    private void doTask() {
        System.out.println(Thread.currentThread().getName() + ": MyTask:BEGIN:context = " + context);
        try {
            Thread.sleep(random.nextInt(3000));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}

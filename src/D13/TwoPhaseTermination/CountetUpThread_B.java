package D13.TwoPhaseTermination;

import java.util.Random;

public class CountetUpThread_B extends GracefulThread {
    private long counter = 0;

    @Override
    protected void doShutdown() {
        System.out.println("do shutdown : counter = " + counter);
    }

    public final static Random random = new Random();

    @Override
    protected void doWork() throws InterruptedException {
        counter++;
        System.out.println("do work : counter = " + counter);
        Thread.sleep(random.nextInt(3000));
    }

}

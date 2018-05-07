package D4.Semaphore;

import java.util.Random;
import java.util.concurrent.Semaphore;

public class BoundedResource {
    private final int permits; //可用资源个数
    private final Semaphore semaphore;
    private final static Random random = new Random(314159);

    public BoundedResource(int permits) {
        this.permits = permits;
        this.semaphore = new Semaphore(permits);
    }

    public void use() throws InterruptedException {
        semaphore.acquire();
        try {
            doUse();
        } finally {
            semaphore.release();

        }

    }

    private void doUse() throws InterruptedException {
        Log.println("BEGIN : used = " + (permits - semaphore.availablePermits()));
        Thread.sleep(random.nextInt(500));
        Log.println("END : used = " + (permits - semaphore.availablePermits()));
    }
}

package D4.Semaphore;

import java.util.Random;

public class UserThread extends Thread {
    private final BoundedResource resource;
    private static final Random random = new Random(26535);

    public UserThread(BoundedResource resource) {
        this.resource = resource;
    }

    @Override
    public void run() {
        try {
            while (true) {
                resource.use();
                Thread.sleep(random.nextInt(3000));
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

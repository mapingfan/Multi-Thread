package D6.ClientServer;

import java.util.Random;

public class ServerThread extends Thread {
    private final RequestQueue requestQueue;
    private final Random random;

    public ServerThread(RequestQueue requestQueue, String name, long seed) {
        super(name);
        this.requestQueue = requestQueue;
        this.random = new Random(seed);
    }

    @Override
    public void run() {
        try {
            for (int i = 0; i < 10000 && !interrupted(); i++) {
                Request request = requestQueue.getRequest();
                System.out.println(Thread.currentThread().getName() + " handles " + request);
                Thread.sleep(random.nextInt(1000));
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

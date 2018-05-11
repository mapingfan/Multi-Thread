package D6.ClientServer;

import java.util.Random;

public class ClientThread extends Thread {
    private final RequestQueue requestQueue;
    private final Random random;

    public ClientThread(RequestQueue requestQueue, String name, long seed) {
        super(name);
        this.requestQueue = requestQueue;
        this.random = new Random(seed);
    }

    @Override
    public void run() {
        try {
            for (int i = 0; i < 10000 && !interrupted(); i++) {
                Request request = new Request("No. " + i);
                System.out.println(Thread.currentThread().getName() + " request" + request);
                requestQueue.putRequest(request);
                Thread.sleep(1000);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

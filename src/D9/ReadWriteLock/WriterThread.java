package D9.ReadWriteLock;

import java.util.Random;

public class WriterThread extends Thread {
    private final Data data;
    private final Random random = new Random();

    public WriterThread(Data data,String name) {
        super(name);
        this.data = data;
    }

    @Override
    public void run() {
        try {
            while (true) {
                char c = nextChar();
                data.write(c);
                Thread.sleep(50);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private char nextChar() {
        return (char) ('a' + random.nextInt(26));

    }
}

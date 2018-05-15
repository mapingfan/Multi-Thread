package D9.ReadWriteLock;

public class ReaderThread extends Thread {
    private final Data data;

    public ReaderThread(Data data, String name) {
        super(name);
        this.data = data;
    }

    @Override
    public void run() {
        try {
            while (true) {

                char[] buffer = data.read();
                System.out.println(Thread.currentThread().getName() + "read " + String.valueOf(buffer));
                sleep(50);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}

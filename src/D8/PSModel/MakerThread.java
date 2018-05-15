package D8.PSModel;

import java.util.concurrent.atomic.AtomicInteger;

public class MakerThread extends Thread {
    private final Table table;
    private static AtomicInteger integer = new AtomicInteger(0);

    public MakerThread(Table table, String name) {
        super(name);
        this.table = table;
    }

    @Override
    public void run() {
        try {
            while (!interrupted()) {
                String cake = "No. " + integer.addAndGet(1);
                table.put(cake);
                System.out.println(Thread.currentThread().getName() + " put " + cake);
            }
        } catch (InterruptedException e1) {
            e1.printStackTrace();
        }
    }
}


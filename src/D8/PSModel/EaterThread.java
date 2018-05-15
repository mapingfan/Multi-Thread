package D8.PSModel;

public class EaterThread extends Thread {
    private final Table table;

    public EaterThread(Table table, String name) {
        super(name);
        this.table = table;
    }

    @Override
    public void run() {
        try {
            while (!interrupted()) {
                String cake = table.take();
                System.out.println(Thread.currentThread().getName() + " take " + cake);
                Thread.sleep(1000);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

package D8.Exe;

public class Host {
    public static void execute(int count) throws InterruptedException {
        for (int i = 0; i < count; i++) {
            if (Thread.currentThread().isInterrupted()) {
                Thread.interrupted();
                throw new InterruptedException();
            }
            doHeavyJob();
        }
    }

    private static void doHeavyJob() {
        System.out.println("doHeavyJob begin");
        long start = System.currentTimeMillis();
        while (start + 10000 > System.currentTimeMillis()) {

        }
        System.out.println("doHeavyJob end");
    }
}

package D13.HanoiHomework;

public class HanoiThread extends Thread {
    private volatile boolean shutdownRequested = false;
    private volatile long requestedTimeMillis = 0;

    public void shutdownRequest() {
        requestedTimeMillis = System.currentTimeMillis();
        shutdownRequested = true;
        interrupt();
    }

    public boolean isShutdownRequested() {
        return shutdownRequested;
    }

    @Override
    public void run() {
        try {
            for (int level = 0; !isShutdownRequested(); level++) {
                System.out.println("==== Level " + level + " ====");
                doWork(level, "A", "B", "C");
                System.out.println();
            }
        } finally {
            doShutdown();
        }
    }

    private void doWork(int level, String a, String b, String c) {
        if (level > 0) {
//            if (isShutdownRequested()) {
//                throw new InterruptedException();
//            }
            doWork(level - 1, a, c, b); //经过b运到c.
            System.out.print(a + "->" + b + " ");
            doWork(level - 1, c, b, a); //目的是b.
        }
    }

    private void doShutdown() {
        long time = System.currentTimeMillis() - requestedTimeMillis;
        System.out.println("do shutdown Latency : " + time + " msec.");
    }
}

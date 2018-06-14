package D13.TwoPhaseTermination;

public class CounterUpThread extends Thread {

    private volatile boolean shutdownRequested = false;
    private int counter = 0;

    public void shutdownRequest() {
        shutdownRequested = true;
        interrupt();
    }

    public boolean isShutdownRequested() {
        return shutdownRequested;
    }

    @Override
    public void run() {
        try {
            while (!isShutdownRequested()) {
                doWork();
            }
        } catch (InterruptedException e) {

        } finally {
            doShutdown();
        }

    }

    private void doShutdown() {
        System.out.println("doShutdown: counter" + counter);
    }

    private void doWork() throws InterruptedException {
        counter++;
        System.out.println("doWork: counter" + counter);
        sleep(500);

    }
}

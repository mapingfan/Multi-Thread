package D13.Homework;

public class MyServiceThread extends D13.TwoPhaseTermination.GracefulThread {
    @Override
    protected void doShutdown() {
        System.out.println("done.");
    }

    @Override
    protected void doWork() throws InterruptedException {
        System.out.print("service");
        try {
            for (int i = 0; i < 50; i++) {
                System.out.print(".");
                Thread.sleep(100);
            }
        } catch (InterruptedException e) {
        } finally {
            System.out.println("done.");
        }
    }
}

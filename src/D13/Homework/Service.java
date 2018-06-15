package D13.Homework;

import D13.TwoPhaseTermination.GracefulThread;

public class Service {
    private static GracefulThread gt = null;

    public synchronized static void service() {
        if (gt != null && gt.isAlive()) {
            System.out.println("baking");
            return;
        }
        gt = new MyServiceThread();
        gt.start();
    }


    public synchronized static void cancel() {
        if (gt != null) {
            System.out.println("cancel.");
            gt.shutdownRequest();
        }

    }
}

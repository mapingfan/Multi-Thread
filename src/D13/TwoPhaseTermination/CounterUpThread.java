package D13.TwoPhaseTermination;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;

public class CounterUpThread extends Thread {

    //    private volatile boolean shutdownRequested = false;
    private int counter = 0;

    public void shutdownRequest() {
//        shutdownRequested = true;
        interrupt();
    }

//    public boolean isShutdownRequested() {
//        return shutdownRequested;
//    }

    @Override
    public void run() {
        try {
            while (!isInterrupted()) {
                doWork();
            }
        } finally {
            doShutdown();
        }

    }

    private void doShutdown() {
        try (FileWriter fw = new FileWriter("counter.txt")) {
            fw.write("counter = " + counter);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("doShutdown: counter" + counter);
    }

    private void doWork() {
        counter++;
        System.out.println("doWork: counter" + counter);
        try {
            sleep(500);
        } catch (InterruptedException e) {
//            e.printStackTrace();
//            interrupted();
            shutdownRequest();

        }

    }
}

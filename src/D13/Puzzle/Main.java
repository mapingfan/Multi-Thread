package D13.Puzzle;

import jdk.nashorn.internal.runtime.regexp.joni.exception.InternalException;

public class Main {
    public static void main(String[] args) {
        Thread t = new Thread() {
            @Override
            public void run() {
                while (true) {
                    try {
                        if (Thread.currentThread().isInterrupted()) {
                            throw new InterruptedException();
                        }
                        System.out.print(".");
                    } catch (InterruptedException e) {
//                        e.printStackTrace();
                        System.out.print("*");
                        break;
                    }
                }
            }
        };

        t.start();

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {

        }
        t.interrupt();
    }
}

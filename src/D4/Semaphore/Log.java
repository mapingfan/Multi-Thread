package D4.Semaphore;

public class Log {

    public static void println(String message) {
        System.out.println(Thread.currentThread().getName() + ": " + message);
    }
}

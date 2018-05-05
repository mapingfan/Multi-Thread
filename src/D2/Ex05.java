package D2;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Ex05 {
    public static void main(String[] args) {
        ExecutorService threadPool = Executors.newFixedThreadPool(10);
        for (int i = 0; i < 100; i++) {
            threadPool.execute(() -> System.out.println(Thread.currentThread().getName()));
        }
        threadPool.shutdownNow();

    }
}

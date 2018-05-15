package D8.Exe;

public class Main {
    public static void main(String[] args) {
        Thread thread = new Thread(() -> {
            try {
                Host.execute(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        thread.start();
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("begin interrupt");
        thread.interrupt();
        System.out.println("task end");

    }
}

package D13.TwoPhaseTermination;

public class Main {

    public static void main(String[] args) {
        System.out.println("main : begin");
        Thread.setDefaultUncaughtExceptionHandler((t, e) -> System.out.println("hhhhh"));
        Runtime.getRuntime().addShutdownHook(new Thread(() -> System.out.println("ggg")));
        try {

            CounterUpThread cut = new CounterUpThread();
            cut.start();
            Thread.sleep(10000);
            System.out.println("main : shutdown request");
            cut.shutdownRequest();
            System.out.println();
            System.out.println("main : join");
            cut.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("main : end");

    }
}

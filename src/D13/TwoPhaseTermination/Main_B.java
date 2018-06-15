package D13.TwoPhaseTermination;

public class Main_B {

    public static void main(String[] args) {
        System.out.println("main : begin");
//        Thread.setDefaultUncaughtExceptionHandler((t, e) -> System.out.println("hhhhh"));
//        Runtime.getRuntime().addShutdownHook(new Thread(() -> System.out.println("ggg")));
        try {
            CountetUpThread_B cutb = new CountetUpThread_B();
            cutb.start();
            Thread.sleep(10000);
            System.out.println("main : shutdown request");
            cutb.shutdownRequest();
            System.out.println();
            System.out.println("main : join");
            cutb.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("main : end");

    }
}

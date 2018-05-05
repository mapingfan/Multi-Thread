package D2;

public class Ex02 {
    public static void main(String[] args) {
        new Thread(() -> System.out.println("runnalbe线程")).start();
        new Thread(() -> System.out.println("---")).start();
        new Thread(() -> System.out.println("---")).start();

        new Thread(() -> System.out.println("--")) {
            @Override
            public void run() {
                System.out.println("----");
            }
        }.start();


    }
}

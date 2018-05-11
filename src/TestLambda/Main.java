package TestLambda;

public class Main {

    public static void main(String[] args) {
        new Thread(() -> System.out.print(Thread.currentThread().getName())).start();
    }
}

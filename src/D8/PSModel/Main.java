package D8.PSModel;

/**
 * 生产者消费者模式.
 */
public class Main {
    public static void main(String[] args) {
        Table table = new Table(10);
        new MakerThread(table, "M1").start();
        new MakerThread(table, "M2").start();
        new MakerThread(table, "M3").start();
        new EaterThread(table, "E1").start();
        new EaterThread(table, "E2").start();
        new EaterThread(table, "E3").start();
    }
}

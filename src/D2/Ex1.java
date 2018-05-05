package D2;

public class Ex1 extends Thread {

    public Ex1(String name) {
        super(name);
    }

    @Override
    public void run() {
        while (!interrupted()) {
            System.out.println(getName() + "运行...");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }

    public static void main(String[] args) throws InterruptedException {
        Ex1 t1 = new Ex1("t1");
        Ex1 t2 = new Ex1("t2");
//        t1.setDaemon(true);
//        t2.setDaemon(true); //支持线程,如果主线程结束,那么即使此线程没执行完,那么也得随主线一起结束.

        t1.start();
        t2.start();

        t1.interrupt();
//        Thread.sleep(2_000);
    }
}

package Thread;

public class MyThread implements Runnable {


    @Override
    public synchronized void run() {
        while (true) {
            System.out.println("子线程正在允许.");
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        MyThread my = new MyThread();
        Thread t1 = new Thread(my);
        t1.start();
        while (true) {
            synchronized (my) {
                System.out.println("主线程正在运行.");
                my.notify();
            }
        }

    }
}

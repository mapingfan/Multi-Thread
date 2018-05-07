package D3;

/**
 * 线程安全性问题
 */
public class Ex02 {

    public static void main(String[] args) {
        Sequence sequence = new Sequence();
        new Thread(() -> {
            while (true) {
                System.out.println(Thread.currentThread().getName() + " ---" + sequence.getNext());
            }
        }).start();

        new Thread(() -> {
            while (true) {
                System.out.println(Thread.currentThread().getName() + " ---" + sequence.getNext());
            }
        }).start();

    }
}


class Sequence {
    private int value = 0;


    public  int getNext() {
        synchronized (this) {
            return value++;
        }
    }
}
package D8.PSModel;

import java.util.concurrent.ArrayBlockingQueue;

/**
 * 使用阻塞队列,无需自己手动控制同步过程.直接往里加和取就好.同步由内部帮你隐藏好了.
 * 这个地方让我惊奇的是这种写法,直接继承阻塞队列这个类.
 * 然后使用super方法直接调用父类的方法
 */
public class Table extends ArrayBlockingQueue<String> {
    private static final int MAX = 5;
    private final String[] buffer = new String[MAX];
    int head = 0, tail = 0, count = 0; //head代表从当前位置取蛋糕,tail表示从当前位置放蛋糕.count代表蛋糕数量.

    public Table(int capacity) {
        super(capacity);
    }

    public synchronized void put(String cake) throws InterruptedException {
        /*while (count == MAX) { //已满了.放的线程需要等待.
            wait();
        }
        buffer[tail] = cake;
        tail = (tail + 1) % MAX;
        count++;
        notifyAll();*/
        //上面的同步关键字可以删除.
        System.out.println(Thread.currentThread().getName() + " put a cake");

        super.put(cake);

    }

    public synchronized String take() throws InterruptedException {
        /*while (count == 0) {
            wait();
        }
        String cake = buffer[head];
        head = (head + 1) % MAX;
        count--;
        notifyAll();*/
        String cake = super.take();
        System.out.println(Thread.currentThread().getName() + " takes a cake");
        return cake;
    }
}

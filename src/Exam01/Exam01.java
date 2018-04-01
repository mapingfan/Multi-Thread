package Exam01;


import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 写一个多线程程序,主线程循环一百次时,让子线程循环10次,循环.
 * 实现思路:两个线程首先一定得互斥,现有的互斥工具只有synchronized/lock.然后两个线程需要协调执行,我执行
 * 完了需要告诉你,你执行完了需要告诉我.线程直接的通信协调用过volatile变量,wait/notify进行.
 * <p>
 * 这个版本用synchronized实现互斥.下面尝试下lock锁.
 *
 *lock锁的进程需要通信,需要使用condition对象的await/signal方法.这点需要注意,不能接着用wait/notify方法进行通信.
 */
class LockVersion {
    private volatile boolean shouldSub = true;
    Lock lock = new ReentrantLock();
    Condition condition = lock.newCondition();

    public void sub() {
        lock.lock();
        try {
            while (shouldSub) {
                condition.await();
            }
            for (int i = 0; i < 100; i++) {
                System.out.println("我是主线程,循环第" + (i + 1) + "次.");
            }

        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            shouldSub = true;
            condition.signal();
            lock.unlock();
        }
    }

    public void main() {
        lock.lock();
        try {
            while (!shouldSub) { //用while循环防止虚假唤醒.
                condition.await();
            }
            for (int i = 0; i < 10; i++) {
                System.out.println("我是子线程,循环第" + (i + 1) + "次.");
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            shouldSub = false;  //sub线程执行玩一次了,应该等待了,让主线程执行.
            condition.signal();
            lock.unlock();
        }
    }

}


public class Exam01 {

    private boolean shouldSub = true; //代表应该子线程执行.

    public synchronized void sub() {
        while (!shouldSub) { //用while循环防止虚假唤醒.
            try {
                this.wait(); //如果不是sub线程执行,那么应该等待.
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        for (int i = 0; i < 10; i++) {
            System.out.println("我是子线程,循环第" + (i + 1) + "次.");
        }
        shouldSub = false;  //sub线程执行玩一次了,应该等待了,让主线程执行.
        this.notify();      //通知主线程执行.唤醒操作.
    }

    public synchronized void primary() {
        while (shouldSub) {
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        for (int i = 0; i < 100; i++) {
            System.out.println("我是主线程,循环第" + (i + 1) + "次.");
        }
        shouldSub = true;
        this.notify();
    }

    public static void main(String[] args) throws InterruptedException {
        final Exam01 e = new Exam01();

//        new Thread(new Runnable() {
//            @Override
//            public void run() {
//                for (int i = 0; i < 50; i++) {
//                    e.sub();
//                }
//            }
//        }).start();
//
//        new Thread(new Runnable() {
//            @Override
//            public void run() {
//                for (int i = 0; i < 50; i++) {
//                    e.primary();
//                }
//            }
//        }).start();

        final LockVersion lockVersion = new LockVersion();
        new Thread(new Runnable() {

            @Override
            public void run() {
                for (int i = 0; i < 50; i++) {

                    lockVersion.sub();
                }
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 50; i++) {
                    lockVersion.main();
                }
            }
        }).start();

    }
}

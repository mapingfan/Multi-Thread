package D4.PassGate_homework.PassGate;

import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.ReentrantLock;

public class Mutex {
    //我得方法,方法一,下面看下方法二
//    private final Semaphore semaphore = new Semaphore(1);
//
//    public  void lock() {
//        try {
//            semaphore.acquire();
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//    }
//
//    public  void unlock() {
//        semaphore.release();
//    }

    //方法二
    /*private boolean isBusy = false;

    public synchronized void lock() {
        while (isBusy) {
            try {
                wait();  //等待mutex对象的锁.
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        isBusy = true; //isBusy 不需要volatile,同步关键字隐含这个功能.
    }

    public synchronized void unlock() {
        isBusy = false;
        notifyAll();
    }*/

    //方法三,改进上面的问题.上面的锁不能重入,如果一个线程连续两次调用lock,那么会发生把自己锁在门外的情况.
    private int locks = 0; //一开始锁的数量
    private Thread owner = null; //当前锁拥有者.

    public synchronized void lock() {
        Thread me = Thread.currentThread();
        while (locks > 0 && owner != me) { //如果已经有锁了,或者不是上一个线程.那么就来一个等一个.
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        assert locks == 0 || owner == me; //不满足while的条件,可能是没有锁或者就是我自身(保证重入).
        owner = me; //设置所有者.
        locks++; //锁的数量加1.
    }

    //只有获得锁的线程才能解锁.只有锁的数量>0解锁才有意义.
    public synchronized void unlock() {
        Thread me = Thread.currentThread();
        if (locks == 0 || owner != me) return; //如果没有加锁,那么解锁无意义.如果不是我加的锁,那么不许别人解锁.
        assert locks > 0 && owner == me; //不满足if后,那么一定加了锁,并且是我加的锁,这样才能解锁.
        locks--;
        if (locks == 0) {  //因为锁重入,会导致一个线程有多个锁.只有这个线程的锁解完了.才能重置所有者,唤醒wait的线程.
            owner = null;
            notifyAll();
        }

    }

    //最后一个方法就是Mutex类继承ReentrantLock锁,不需要实现任何方法,然后就有了lock操作.

}

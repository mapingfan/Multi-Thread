package D9.ReadWriteLock;

public class MyReadWriteLock {

    private int readingReaders = 0; //正在读的线程个数.即已经获取了锁.
    private int writingWriters = 0; //正在写的线程个数,只能为1或者0.
    private int waitingWriters = 0; //等待写的线程.即因为可能存在的冲突而等待的线程/
    private boolean isPreferWirter = true; //写优先.

    /**
     * 什么情况可以获取读锁,什么情况不能.
     * 如果有写线程存在,不能.需要等待.
     * 有等待写的线程存在,等待.
     *
     * 如果有偏向写着,那么当存在等待写线程时,应该优先考虑等待写的线程,即不能把读锁分配给读线程.
     */
    public synchronized void readLock() throws InterruptedException {
        while (writingWriters > 0 || (isPreferWirter && waitingWriters > 0)) { //如果有偏向写者.
            wait(); //等待读写锁对象的monitor被获取.
        }
        //通过了while判断,那么可以获取锁.
        readingReaders++;
    }

    /**
     * 所有读线程执行完需要进行唤醒.
     */
    public synchronized void unReadLock() {
        /*if (readingReaders > 0) {
            readingReaders--;
            if (readingReaders == 0) {
                notifyAll();
            } else {
                return;
            }
        }
        notifyAll();*/
        /**
         * 上面我的唤醒策略是等待所有的线程都读完,然后才唤醒.这样有一个潜在的问题.那么当我释放一个读锁,然后又来了一个读锁,这样会
         * 导致读线程一直占据,没有做到写优先策略.
         * 好的做法是每次释放一个读锁,就唤醒所有线程.让等待的写线程有机会阻塞或者执行.
         */
        readingReaders--;
        isPreferWirter = true;
        notifyAll();  //公平竞争,不能一直等读锁释放完了才唤醒.
    }

    /**
     * 什么情况可以获取写锁.
     * 没有正在读的,没有正在写的.写操作和任何操作都冲突.
     */
    public synchronized void writeLock() throws InterruptedException {
        waitingWriters++;
        try {

            while (writingWriters > 0 || readingReaders > 0) {
                wait();
            }
        }finally {
            waitingWriters--;  //?为什么这样写?
        }
        writingWriters++;
    }

    /**
     * 释放写锁.
     */
    public synchronized void unWriteLock() {
       /* if (writingWriters > 0) {
            if (--writingWriters == 0) {
                notifyAll();
            } else {
                return;
            }
        }
        notifyAll();*/
       //公平策略.
        writingWriters--;
        isPreferWirter = false;
        notifyAll();
    }
}

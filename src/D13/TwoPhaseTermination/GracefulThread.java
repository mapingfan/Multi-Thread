package D13.TwoPhaseTermination;

public class GracefulThread extends Thread {
    private volatile boolean shutdownRequested = false;

    //思考为何写成final.对于子类不需要重写.
    public final void shutdownRequest() {
        shutdownRequested = true;
        interrupt(); //this.interrupt().表明当前正在执行的线程被中断.
        //如果写成        Thread.currentThread().interrupt(),那么会导致调用这个shutdownRequest()方法的线程被中断.
    }

    public final boolean isShutdownRequested() {
        return shutdownRequested;
    }

    @Override
    public final void run() {
        try {
            while (!isShutdownRequested()) {
                doWork();
            }
        } catch (InterruptedException e) {

        } finally {
            doShutdown();
        }
    }


    //设计成protected方法,便于子类重写.
    protected void doShutdown() {

    }

    protected void doWork() throws InterruptedException {

    }
}

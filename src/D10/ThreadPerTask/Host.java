package D10.ThreadPerTask;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ThreadFactory;

public class Host {

    private final Helper help = new Helper();
    private final ThreadFactory factory;
    private final ExecutorService executorService;

    public Host(ThreadFactory factory, ExecutorService executorService) {
        this.factory = factory;
        this.executorService = executorService;
    }

    private static void execute(Runnable command) {
        new Thread(command).start();
    }


    public void request(int count, char a) {
        System.out.println("Request begin execute ( " + count + " " + a + " )");
//        new Thread(() -> help.execute(count, a)).start();
        //下面尝试多种线程启动方式.
//        factory.newThread(() -> help.execute(count, a)).start();
//        executorService.execute(() -> help.execute(count, a));
//        executorService.shutdown();
//        ((ThreadFactory) Thread::new).newThread(() -> help.execute(count, a)).start();
        ((Executor) Host::execute).execute(() -> help.execute(count, a));
        System.out.println("Request end execute ( " + count + " " + a + " )");
    }
}

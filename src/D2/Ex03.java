package D2;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class Ex03 implements Callable<Integer> {  //接口的泛型表明返回值的类型.
    @Override
    public Integer call() throws Exception {
        System.out.println("正在进行紧张的计算");
        Thread.sleep(1000);
        return 1;
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        Ex03 ex03 = new Ex03(); //任务的封装,相当于runnable
        FutureTask<Integer> task = new FutureTask<>(ex03);
        Thread thread = new Thread(task);
        System.out.println("我先干点别的");
        thread.start();
        Integer result = task.get();
        System.out.println(result);

    }
}

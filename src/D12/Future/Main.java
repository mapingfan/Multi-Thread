package D12.Future;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class Main {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        System.out.println("Main BEGIN");
        Host host = new Host();
       /* Data data1 = host.request(10, 'A');
        Data data2 = host.request(20, 'B');
        Data data3 = host.request(30, 'C');*/

        //下面是改进版本.
        FutureTask<RealData> data1 = host.request(10, 'A');
        FutureTask<RealData> data2 = host.request(20, 'B');
        FutureTask<RealData> data3 = host.request(30, 'C');

        System.out.println("main otherJob BEGIN");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("main otherJob END");
        System.out.println("data1 = " + data1.get());
        System.out.println("data2 = " + data2.get());
        System.out.println("data3 = " + data3.get());
        System.out.println("main END");

    }
}

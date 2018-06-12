package D12.Future;

import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

public class Host {
    /*public Data request(int count, char c) {
        System.out.println(" Request(" + count + " , " + c + ") BEGIN");
        FutureData future = new FutureData();

        new Thread(() -> {
            RealData realData = new RealData(count,c);
            future.setRealData(realData);
        }).start();
        System.out.println(" Request(" + count + " , " + c + ") END");

        return future;
    }*/

    //下面是改进版.

    public FutureTask<RealData> request(int count, char c) {
        System.out.println(" Request(" + count + " , " + c + ") BEGIN");
        FutureTask<RealData> future = new FutureTask<>(() -> {
            RealData realData = new RealData(count, c);
            return realData;
        });
//        future.run();
        new Thread(future).start();

       /* new Thread(() -> {
            RealData realData = new RealData(count, c);
            future.setRealData(realData);
        }).start();*/
        System.out.println(" Request(" + count + " , " + c + ") END");

        return future;
    }
}

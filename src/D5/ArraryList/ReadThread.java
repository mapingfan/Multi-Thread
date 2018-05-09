package D5.ArraryList;

import java.util.List;

public class ReadThread extends Thread {
    private final List<Integer> list;

    public ReadThread(List<Integer> list) {
        this.list = list;
    }

    @Override
    public void run() {
        while (true) {
            for (Integer integer : list) {
                System.out.println(integer);
            }
        }
    }
}

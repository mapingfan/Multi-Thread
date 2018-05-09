package D5.ArraryList;

import java.util.List;

public class WriteThread extends Thread {
    private final List<Integer> list;

    public WriteThread(List<Integer> list) {
        this.list = list;
    }

    @Override
    public void run() {
        for (int i = 0; true ; i++) {
            list.add(i);
            list.remove(0);
        }
    }
}

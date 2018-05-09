package D5.ArraryList;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * 写一个程序,使得Arraylist线程不安全.
 * 然后修改成安全的.
 */
public class Main {

    public static void main(String[] args) {
//        List<Integer> arrayList = Collections.synchronizedList(new ArrayList<>());
        List<Integer> arrayList = new CopyOnWriteArrayList<>();
        new ReadThread(arrayList).start();
        new WriteThread(arrayList).start();
    }
}

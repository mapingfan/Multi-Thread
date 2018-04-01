package Timer;

import java.util.Timer;
import java.util.TimerTask;

public class TestTimer {
    /**
     * Timer 定时器
     * TimerTask 定时器的任务. 定时器通过Timer的schedule方法进行调度执行.
     * schedule方法有几个重载方法.需要详查.
     */
    public static void main(String[] args) {
        new Timer().schedule(new TimerTask() {
            @Override
            public void run() {
                System.out.println("---");
            }
        },1000);
    }
}

package D2;

import java.util.Timer;
import java.util.TimerTask;

public class Ex04 {

    public static void main(String[] args) {
        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                System.out.println("-0-");
            }
        }, 0, 1000);
    }
}

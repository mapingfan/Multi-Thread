package D7.AutomaticSave;

import java.io.IOException;
import java.util.Random;

public class ChangerThread extends Thread {
    private final Data data;
    private final static Random random = new Random();

    public ChangerThread(Data data, String name) {
        super(name);
        this.data = data;
    }

    @Override
    public void run() {
        try {
            for (int i = 0; true; ++i) {
                data.change("No. " + i);
                Thread.sleep(random.nextInt(1000));
                data.save();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

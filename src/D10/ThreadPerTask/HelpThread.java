package D10.ThreadPerTask;

public class HelpThread extends Thread {
    private final Helper helper;
    private final int count;
    private final char aChar;

    public HelpThread(Helper helper, int count, char aChar) {
        this.helper = helper;
        this.count = count;
        this.aChar = aChar;
}

    @Override
    public void run() {
        helper.execute(count, aChar);
    }
}

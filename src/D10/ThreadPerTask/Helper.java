package D10.ThreadPerTask;

public class Helper {
    /**
     * 将字符a,显示count次.
     * @param count
     * @param a
     */
    public void execute(int count, char a) {
        for (int i = 0; i < count; i++) {
            slowly();
            System.out.print(a + " ");
        }
        System.out.println();
    }

    private void slowly() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

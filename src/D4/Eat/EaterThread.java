package D4.Eat;


public class EaterThread extends Thread {
    private final Tool leftHand;
    private final Tool rightHand;
    private String name;

    public EaterThread(Tool leftHand, Tool rightHand, String name) {
        this.leftHand = leftHand;
        this.rightHand = rightHand;
        this.name = name;
    }

    @Override
    public void run() {
        while (true) {
            eat();
        }
    }

    private void eat() {
        synchronized (leftHand) { //先获得左手的餐具.
            System.out.println(this.name + " takes up " + leftHand.getName() + " left");
            synchronized (rightHand) {
                System.out.println(this.name + " takes up " + rightHand.getName() + " right");
                System.out.println(this.name + " is eating now, yum yum!");
                System.out.println(this.name + " puts down " + rightHand.getName() + " right");
            }
            System.out.println(this.name + " puts down " + leftHand.getName() + " left");
        }
    }
}

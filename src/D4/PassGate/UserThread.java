package D4.PassGate;

public class UserThread extends Thread {

    private final Gate gate;
    private final String myname;
    private final String myaddress;

    public UserThread(Gate gate, String myname, String myaddress) {
        this.gate = gate;
        this.myname = myname;
        this.myaddress = myaddress;
    }

    @Override
    public void run() {
        System.out.println(myname + " BEGIN ");
        try {

            while (true) {
                gate.pass(myname, myaddress);
                Thread.sleep(2_000);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

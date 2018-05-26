package D10.Magic;

public class BlackHole {
    public static void enter(Object obj) {
        System.out.println("step 1");
        magic(obj);
        System.out.println("step 2");
        synchronized (obj) {
            System.out.println("step 3");
        }
    }

    private static void magic(Object obj) {
        Thread thread = new Thread() {
            @Override
            public void run() {
                synchronized (obj) {
                    synchronized (this) {
                        this.setName("Locked");
                        this.notifyAll();
                    }
                    while (true) {

                    }
                }

            }
        };
        synchronized (thread) {
            thread.setName("");
            thread.start();
            while (thread.getName().equals("")) {

                try {
                    thread.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}

package D4.PassGate_homework.PassGate;

import lombok.Data;

@Data
public class Gate {
    private int counter;
    private String name;
    private String address;
    private final Mutex mutex = new Mutex();


    public void pass(String name, String address) {
        mutex.lock();
            try {
                this.name = name;
                this.address = address;
                counter++;
                check();
        } finally {
            mutex.unlock();
        }

    }

    @Override
    public String toString() {
        mutex.unlock();
        try {

        return "Gate{" +
                "counter=" + counter +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                '}';
        } finally {
            mutex.unlock();
        }

    }

    private void check() {
        if (name.charAt(0) != address.charAt(0)) {
            System.out.println("****** BROKEN ******" + toString());
        }
    }
}

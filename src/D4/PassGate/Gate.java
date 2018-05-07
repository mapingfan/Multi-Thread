package D4.PassGate;

import lombok.Data;

@Data
public class Gate {
    private int counter;
    private String name;
    private String address;

    public synchronized void pass(String name, String address) {
        this.name = name;
        this.address = address;
        counter++;
        check();
    }

    @Override
    public  String toString() {
        return "Gate{" +
                "counter=" + counter +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                '}';
    }

    private void check() {
        if (name.charAt(0) != address.charAt(0)) {
            System.out.println("****** BROKEN ******" + toString());
        }
    }
}

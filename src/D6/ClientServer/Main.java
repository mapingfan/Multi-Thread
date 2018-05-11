package D6.ClientServer;

public class Main {

    public static void main(String[] args) {
        RequestQueue input = new RequestQueue();
        RequestQueue output = new RequestQueue();
        input.putRequest(new Request("start"));
//        new TalkThread(input, output, "Alice").start();
//        new TalkThread(output, input, "Bobby").start();
        ClientThread alice = new ClientThread(input, "Alice", 132312L);
        ServerThread bobby = new ServerThread(input, "Bobby", 3232323L);
        alice.start();
        bobby.start();

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("calling interrupt");
        alice.interrupt();
        bobby.interrupt();
    }
}

package D10.MiniServer;

import sun.dc.pr.PRError;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MiniServer {
    private final int portnumber;
    private final ExecutorService executorService = Executors.newCachedThreadPool();

    public MiniServer(int portnumber) {
        this.portnumber = portnumber;
    }

    public void execute() throws IOException {
        ServerSocket serverSocket = new ServerSocket(portnumber);
        System.out.println("Listening on " + serverSocket);
        try {
            while (true) {
                System.out.println("Accepting...");
                Socket clientSocket = serverSocket.accept();
                System.out.println("Connected to " + clientSocket);
                executorService.execute(() -> {
                    try {
                        Service.service(clientSocket);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                });
            }
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            serverSocket.close();
        }
    }
}

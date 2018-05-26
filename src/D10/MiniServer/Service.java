package D10.MiniServer;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class Service {
    private Service() {

    }
    public static void service(Socket clientSocket) throws IOException {
        System.out.println(Thread.currentThread().getName() + ": Service.service(" +
                clientSocket + ") BEGIN");
        try{
            DataOutputStream dos = new DataOutputStream(clientSocket.getOutputStream());
            dos.writeBytes("HTTP/1.0 200 OK\r\n");
            dos.writeBytes("Content-type: text/html\r\n");
            dos.writeBytes("\r\n");
            dos.writeBytes("<html><head><title>Countdowm</title></head><body>");
            dos.writeBytes("<h1>Count Down Start! <h1>");
            for (int i = 10; i > 0; i--) {
                System.out.println(Thread.currentThread().getName() + ": CountDown i = " + i);
                dos.writeBytes("<h1>" + i + "</h1>");
                dos.flush();
                try{
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            dos.writeBytes("</body></html>");
        }finally {
            clientSocket.close();
        }
        System.out.println(Thread.currentThread().getName() + ": Service.service(" + clientSocket + ") END");
    }
}

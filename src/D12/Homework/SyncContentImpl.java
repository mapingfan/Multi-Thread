package D12.Homework;

import java.io.DataInputStream;
import java.io.EOFException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

public class SyncContentImpl implements Content {
    private byte[] contentBytes;

    public SyncContentImpl(String urlstr) {
        System.out.println(Thread.currentThread().getName() + ": Getting " + urlstr);
        try {
            URL url = new URL(urlstr);
            DataInputStream in = new DataInputStream(url.openStream());
            byte[] buffer = new byte[1];
            int index = 0;
            try {
                while (true) {
                    int c = in.readUnsignedByte();
                    if (buffer.length <= index) {
                        byte[] largerBuffer = new byte[buffer.length * 2];
                        System.arraycopy(buffer, 0, largerBuffer, 0, index);
                        buffer = largerBuffer;
                    }
                    buffer[index++] = (byte) c;
                }
            } catch (EOFException e) {
            } finally {
                in.close();
            }
            contentBytes = new byte[index];
            System.arraycopy(buffer, 0, contentBytes, 0, index);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    @Override
    public byte[] getBytes() {
        return contentBytes;
    }
}

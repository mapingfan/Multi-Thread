package D9.ReadWriteLock;

import java.util.Arrays;

public class Data {
    private final MyReadWriteLock lock = new MyReadWriteLock();
    private final char[] buffer;

    public Data(int size) {
        buffer = new char[size];
        for (int i = 0; i < this.buffer.length; i++) {
            buffer[i] = '*';
        }
    }

    public char[] read() throws InterruptedException {
        lock.readLock();
        try {
            char[] tmpBuffer = new char[buffer.length];
            System.arraycopy(buffer, 0, tmpBuffer, 0, buffer.length);
            return tmpBuffer;
        }finally {
            lock.unReadLock();
        }
    }


    public void write(char c) throws InterruptedException {
        lock.writeLock();
        try {
            Arrays.fill(buffer, c);
        }finally {
            lock.unWriteLock();
        }
    }
}

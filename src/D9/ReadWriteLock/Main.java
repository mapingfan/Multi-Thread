package D9.ReadWriteLock;

public class Main {

    public static void main(String[] args) {
        Data data = new Data(10);
        new ReaderThread(data, "reader1").start();
        new ReaderThread(data, "reader2").start();
        new ReaderThread(data, "reader3").start();
        new ReaderThread(data, "reader4").start();
        new ReaderThread(data, "reader5").start();
        new ReaderThread(data, "reader6").start();
        new WriterThread(data, "writer1").start();
        new WriterThread(data, "writer2").start();
        new WriterThread(data, "writer3").start();
    }
}

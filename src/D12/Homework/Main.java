package D12.Homework;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        Content conten1 = Retriever.retrieve("http://www.qq.com/");
        Content conten2 = Retriever.retrieve("http://www.baidu.com/");
        Content conten3 = Retriever.retrieve("http://www.google.com/");
        saveToFile("qq.html", conten1);
        saveToFile("baidu.html", conten2);
        saveToFile("google.html", conten3);
        long end = System.currentTimeMillis();
        System.out.println("Elapsed time = " + (end - start) + " msec.");

    }

    private static void saveToFile(String filename, Content content) {
        byte[] bytes = content.getBytes();
        try {
            System.out.println(Thread.currentThread().getName() + ": Saving to " + filename);
            FileOutputStream out = new FileOutputStream(filename);
            for (int i = 0; i < bytes.length; i++) {
                out.write(bytes[i]);
            }
            out.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}

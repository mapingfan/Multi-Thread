package D12.Homework;

public class Retriever {
    public static Content retrieve(String urlstr) {
        return new ASyncContentImpl(urlstr);
    }
}

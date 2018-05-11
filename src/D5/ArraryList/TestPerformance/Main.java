package D5.ArraryList.TestPerformance;

/**
 * 写一个程序,测试加锁和不加锁的开销.
 */
public class Main {
        private static final long CALL_COUNT = 100000000000L;

    public static void main(String[] args) {
        trial("NotSynch", CALL_COUNT, new NotSynch());
        trial("Synch", CALL_COUNT, new Synch());
    }

    private static void trial(String msg, long count, Object object) {
        System.out.println(msg + " BEGIN");
        long start_time = System.currentTimeMillis();
        for (long i = 0; i < count; ++i) {
            object.toString();
        }
        System.out.println(msg + " END");
        System.out.println("Elapsed time  = " + (System.currentTimeMillis() - start_time) + "msec.");
    }

    private static class NotSynch {
        private final String name = "NotSynch";

        @Override
        public String toString() {
            return "NotSynch{" +
                    "name='" + name + '\'' +
                    '}';
        }
    }
    private static class Synch {
        private final String name = "Synch";

        @Override
        public String toString() {
            return "Synch{" +
                    "name='" + name + '\'' +
                    '}';
        }
    }
}

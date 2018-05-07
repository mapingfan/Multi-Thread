package D3;

        import java.util.Arrays;
        import java.util.List;
        import java.util.function.ToIntFunction;

/**
 * Lambda表达式并行计算.
 */
public class Ex01 {

    public static int add(List<Integer> values) {
        values.parallelStream().forEach(value -> System.out.println(value));
        return values.parallelStream().mapToInt(value -> value).sum();
    }

    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 6);
        System.out.println(add(list));
    }
}

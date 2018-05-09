package D4.Eat;

/**
 * 进餐问题模拟
 */
public class Main {
    public static void main(String[] args) {
        Tool left = new Tool("spoon");
        Tool right = new Tool("fork");
        new EaterThread(left, right, "Alice").start();
        new EaterThread(left, right, "Bobby").start();
    }
}

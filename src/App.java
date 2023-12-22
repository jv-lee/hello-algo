import test.Test;

public class App {
    public static void main(String[] args) throws Exception {
        // Test.test();
        System.out.println("走法：" + f2(8));
    }

    public static int f(int n) {
        if (n == 1)
            return 1;
        if (n == 2)
            return 2;
        return f(n - 1) + f(n - 2);
    }

    public static int f2(int n) {
        if (n == 1) return 1;
        return f(n - 1) + 1;
    }
}

package demo8;

import java.util.function.IntConsumer;

public class Test {
    public static void target(int i) { }

    public static void main(String[] args) throws Exception {
        long current = System.currentTimeMillis();
        for (int i = 1; i <= 2_000_000_000; i++) {
            if (i % 100_000_000 == 0) {
                long temp = System.currentTimeMillis();
                System.out.println(temp - current);
                current = temp;
            }

            ((IntConsumer) j -> Test.target(j)).accept(128);
            // ((IntConsumer) Test::target.accept(128);
        }
    }
}
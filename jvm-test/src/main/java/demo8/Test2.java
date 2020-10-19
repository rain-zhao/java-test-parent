package demo8;

import java.util.function.IntConsumer;

public class Test2 {
    public static void target(int i) { }

    public static void main(String[] args) throws Exception {
        int x = 2;

        long current = System.currentTimeMillis();
        for (int i = 1; i <= 2_000_000_000; i++) {
            if (i % 100_000_000 == 0) {
                long temp = System.currentTimeMillis();
                System.out.println(temp - current);
                current = temp;
            }

            ((IntConsumer) j -> Test2.target(x + j)).accept(128);
        }
    }
}
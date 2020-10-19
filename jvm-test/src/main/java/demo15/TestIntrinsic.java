package demo15;

import java.util.Timer;

public class TestIntrinsic {
    public static int bitCount(int i) {
        // HD, Figure 5-2
        i = i - ((i >>> 1) & 0x55555555);
        i = (i & 0x33333333) + ((i >>> 2) & 0x33333333);
        i = (i + (i >>> 4)) & 0x0f0f0f0f;
        i = i + (i >>> 8);
        i = i + (i >>> 16);
        return i & 0x3f;
    }
    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        int sum = 0;
        for (int i = Integer.MIN_VALUE; i < Integer.MAX_VALUE; i++) {
            sum += bitCount(i); // In a second run, replace with Integer.bitCount
        }
        System.out.println(sum);
        System.out.println("diy bitcount method cost:" + (System.currentTimeMillis() - start));

        start = System.currentTimeMillis();
        sum = 0;
        for (int i = Integer.MIN_VALUE; i < Integer.MAX_VALUE; i++) {
            sum += Integer.bitCount(i); // In a second run, replace with Integer.bitCount
        }
        System.out.println(sum);
        System.out.println("intrinsic bitcount method cost:" + (System.currentTimeMillis() - start));
    }
}

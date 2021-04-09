package base;

import java.util.Arrays;

/**
 * @author dx DingXing
 * @since 2021-01-27
 */
public class DP {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(fib(30)));
        int[][] fib = matrix(3, 7);
    }

    private static int[] fib(int n) {
        int[] cache = new int[n];
        cache[0] = 0;
        cache[1] = 1;

        for (int i = 2; i < n; i++) {
            int rest = cache[i - 1] + cache[i - 2];
            cache[i] = rest;
        }

        return cache;
    }

    private static int[][] matrix(int n, int m) {
        int[][] cache = new int[n][m];
        cache[0][0] = 1;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                int current = 1;
                if (i > 0 && j > 0) {
                    int up = cache[i][j - 1];
                    int left = cache[i - 1][j];
                    current = up + left;
                }

                cache[i][j] = current;
                System.out.print(current + "\t");
            }
            System.out.println();
        }

        return cache;
    }
}

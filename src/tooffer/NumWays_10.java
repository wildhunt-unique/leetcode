package tooffer;

/**
 * 一只青蛙一次可以跳上1级台阶，也可以跳上2级台阶。求该青蛙跳上一个 n 级的台阶总共有多少种跳法
 *
 * @author dx DingXing
 * @since 2021-03-13
 */
public class NumWays_10 {
    public static void main(String[] args) {
        System.out.println(new NumWays_10().numWays(7));
    }

    public int numWays(int n) {
        if (n - 1 < 2) {
            return n == 0 ? 1 : n;
        }

        int[] cache = new int[n];
        cache[0] = 1;
        cache[1] = 2;

        for (int i = 2; i < n; i++) {
            int from1 = cache[i - 1];
            int from2 = cache[i - 2];
            cache[i] = (from1 + from2) % 1000000007;
        }

        return cache[n - 1] % 1000000007;
    }

}

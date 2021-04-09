package tooffer;

/**
 * 斐波那契
 *
 * @author dx DingXing
 * @since 2021-03-13
 */
public class Fib_10 {
    public static void main(String[] args) {
        System.out.println(new Fib_10().fib(5));
    }

    public int fib(int n) {
        int[] cache = new int[]{0, 1};
        if (n < 2) {
            return n;
        }

        int i = 2;
        int last = 0;
        while (i <= n) {
            last = cache[0] + cache[1];
            cache[0] = cache[1];
            cache[1] = last;
            i++;
        }

        return last;


    }

}

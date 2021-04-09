package program;

import java.util.ArrayList;
import java.util.List;

/**
 * 求出第一亿个质数(质数定义为在大于1的自然数中，除了1和它本身以外不再有其他因数。
 *
 * @author 丁星（镜月）
 * @since 2021-03-30
 */
public class OneHundredMillionPrime {
    public static void main(String[] args) {
        long MAX = 100000;

        long begin = 0L;
        begin = System.currentTimeMillis();
        findPrime2(MAX);
        System.out.println("cost2:" + (System.currentTimeMillis() - begin));

        begin = System.currentTimeMillis();
        findPrime3(MAX);
        System.out.println("cost3:" + (System.currentTimeMillis() - begin));
    }

    public static List<Integer> findPrime3(long n) {
        List<Integer> rst = new ArrayList<>((int) n / 2);
        rst.add(2);

        for (int i = 3; i <= n; i++) {
            int max = i / 2 + 1;
            boolean isPrime = true;
            for (int j = 0; j < max && j < rst.size(); j++) {
                if (i % rst.get(j) == 0) {
                    isPrime = false;
                    break;
                }
            }
            if (isPrime) {
                rst.add(i);
            }

        }

        System.out.println(rst);
        return rst;
    }

    public static List<Integer> findPrime2(long n) {
        List<Integer> rst = new ArrayList<>();
        rst.add(2);

        for (int i = 3; i <= n; i++) {
            int max = i / 2 + 1;
            for (int j = 2; j <= max; j++) {
                if (i % j == 0) {
                    break;
                }
                if (i - 1 == j) {
                    rst.add(i);
                }
            }
        }

        return rst;
    }


    public static List<Integer> findPrime1(long n) {
        List<Integer> rst = new ArrayList<>();
        rst.add(2);

        for (int i = 3; i <= n; i++) {
            for (int j = 2; j < i; j++) {
                if (i % j == 0) {
                    break;
                }
                if (i - 1 == j) {
                    rst.add(i);
                }
            }
        }

        return rst;
    }
}

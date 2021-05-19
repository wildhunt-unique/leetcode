package program;

/**
 * @author 丁星（镜月）
 * @since 2021-04-13
 */
public class CPUTrace {
    public static ThreadLocal<String> threadLocal = new InheritableThreadLocal<>();

    public static void main(String[] args) {
//        threadLocal.set("xxxx");
//        System.out.println(threadLocal.get());
//        new Thread(() -> System.out.println(threadLocal.get())).start();
        double x = 1;
        for (; ; ) {
            x = x * 10000 *  1233.4566;
            x = x % 10000;
        }
    }
}

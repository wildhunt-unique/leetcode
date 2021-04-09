package program;

import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author dx DingXing
 * @since 2021-03-10
 */
@SuppressWarnings("all")
public class PrintABC {

    public static void main(String[] args) throws InterruptedException {
        printTest();
    }

    private static void printTest() {
        Object lock = new Object();
        int[] flag = new int[]{0};
        new TestPrinter("C", lock, flag, 2).start();
        new TestPrinter("A", lock, flag, 0).start();
        new TestPrinter("B", lock, flag, 1).start();
    }

    public static class TestPrinter extends Thread {
        private String code;
        private Object lock;
        private int[] flag;
        private int tar;

        public TestPrinter(String code, Object lock, int[] flag, int tar) {
            this.code = code;
            this.lock = lock;
            this.flag = flag;
            this.tar = tar;
        }

        @Override
        public void run() {
            for (int i = 0; i < 10; i++) {
                synchronized (lock) {
                    try {
                        while (flag[0] != tar) {
                            lock.wait();
                        }
                        flag[0] = ++flag[0] % 3;
                        System.out.println(code);
                        lock.notifyAll();
                        lock.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }


    public static void printRen() {
        ReentrantLock lock = new ReentrantLock();
        final int[] state = {0};

        new Thread() {
            @Override
            public void run() {
                for (int i = 0; i < 10; ) {
                    try {
                        lock.lock();
                        while (state[0] % 3 == 2) {
                            System.out.println("C");
                            state[0]++;
                            i++;
                        }
                    } finally {
                        lock.unlock();
                    }

                }
            }
        }.start();

        new Thread() {
            @Override
            public void run() {
                for (int i = 0; i < 10; ) {
                    try {
                        lock.lock();
                        while (state[0] % 3 == 1) {
                            System.out.println("B");
                            state[0]++;
                            i++;
                        }
                    } finally {
                        lock.unlock();
                    }

                }
            }
        }.start();

        new Thread() {
            @Override
            public void run() {
                for (int i = 0; i < 10; ) {
                    try {
                        lock.lock();
                        while (state[0] % 3 == 0) {
                            System.out.println("A");
                            state[0]++;
                            i++;
                        }
                    } finally {
                        lock.unlock();
                    }

                }
            }
        }.start();


    }

    public static void printSam() throws InterruptedException {
        Semaphore s1 = new Semaphore(1);
        Semaphore s2 = new Semaphore(1);
        Semaphore s3 = new Semaphore(1);
        s1.acquire();
        s2.acquire();
        s3.acquire();

        s1.release();
        new Thread() {
            @Override
            public void run() {
                for (int i = 0; i < 10; i++) {
                    try {
                        s1.acquire();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println("A");
                    s2.release();
                }
            }
        }.start();

        new Thread() {
            @Override
            public void run() {
                for (int i = 0; i < 10; i++) {
                    try {
                        s2.acquire();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println("B");
                    s3.release();
                }
            }
        }.start();

        new Thread() {
            @Override
            public void run() {
                for (int i = 0; i < 10; i++) {
                    try {
                        s3.acquire();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println("C");
                    s1.release();
                }
            }
        }.start();
    }

    public static void printSync() {
        Object A = new Object();
        Object B = new Object();
        Object C = new Object();
        new Printer(A, B, "A").start();
        new Printer(B, C, "B").start();
        new Printer(C, A, "C").start();
    }

    public static class Printer extends Thread {
        private Object pre;
        private Object own;
        private String code;

        @Override
        public void run() {
            for (int i = 0; i < 10; i++) {
                try {
                    print();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }

        public void print() throws InterruptedException {
            synchronized (pre) {
                synchronized (own) {
                    System.out.println(code);
                    own.notifyAll();
                }
                pre.notifyAll();
                pre.wait();
            }
        }

        public Printer(Object pre, Object own, String code) {
            this.pre = pre;
            this.own = own;
            this.code = code;
        }
    }
}

package program;

import java.util.LinkedList;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author 丁星（镜月）
 * @since 2021-03-29
 */
public class MineBlockQueen {
    @SuppressWarnings("all")
    public static void main(String[] args) {
        MineBlockQueen mineBlockQueen = new MineBlockQueen(2);

        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                System.out.println("put:" + i);
                mineBlockQueen.put(i);
                try {
                    Thread.sleep(300);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();

        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                System.out.println("get:" + mineBlockQueen.get());
                try {
                    Thread.sleep(700);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }

    private int size;
    private final int maxSize;
    private final ReentrantLock lock;
    /**
     * 可写
     */
    private final Condition nonFull;
    /**
     * 可读
     */
    private final Condition nonEmpty;

    public MineBlockQueen(int maxSize) {
        this.maxSize = maxSize;
        this.size = 0;
        this.lock = new ReentrantLock();
        this.nonFull = this.lock.newCondition();
        this.nonEmpty = this.lock.newCondition();
        this.val = new LinkedList<>();
    }

    private final LinkedList<Object> val;

    public Object get() {
        try {
            lock.lock();
            while (this.size <= 0) {
                System.out.println("Empty to wait");
                this.nonEmpty.await();
            }
            Object first = val.pollFirst();
            size--;
            this.nonFull.signal();
            return first;
        } catch (Exception e) {
            e.printStackTrace();
            this.nonEmpty.signal();
            return null;
        } finally {
            lock.unlock();
        }
    }

    public boolean put(Object o) {
        if (o == null) {
            throw new NullPointerException();
        }
        try {
            lock.lock();
            while (this.size >= this.maxSize) {
                System.out.println("Full to wait:" + o);
                this.nonFull.await();
            }

            val.addLast(o);
            size++;
            nonEmpty.signal();

            return true;
        } catch (Exception e) {
            e.printStackTrace();
            nonEmpty.signal();
            return false;
        } finally {
            lock.unlock();
        }

    }
}

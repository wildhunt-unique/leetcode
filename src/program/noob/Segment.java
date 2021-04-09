package program.noob;

import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @author 丁星（镜月）
 * @since 2021-04-08
 */
public class Segment {
    private int read = 0;



    private ReentrantReadWriteLock rwlock = new ReentrantReadWriteLock();
    private ReentrantReadWriteLock.ReadLock readLock = rwlock.readLock();
    private ReentrantReadWriteLock.WriteLock writeLock = rwlock.writeLock();

    private long getZero() {
        return 0;
    }

    public void cleanUp() {
        try {
            writeLock.tryLock();
            read = 0;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            writeLock.unlock();
        }
    }

    public void onRead() {
        try {
            writeLock.tryLock();
            read++;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            writeLock.unlock();
        }
    }

    public void unRead() {
        try {
            writeLock.tryLock();
            read--;
            read = Math.max(0, read);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            writeLock.unlock();
        }
    }

    public int getReads() {
        try {
            readLock.tryLock();
            return read;
        } catch (Exception e) {
            e.printStackTrace();
            return read;
        } finally {
            readLock.unlock();
        }
    }


    private long lastUpdateWords = 0;
    public void onRead(int x) {
        try {
            writeLock.tryLock();
            if (lastUpdateWords < getZero()) {
                read = 0;
            }
            read += x;
            lastUpdateWords = System.currentTimeMillis();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            writeLock.unlock();
        }
    }
    public int getReadsOnDay() {
        try {
            readLock.tryLock();
            if (lastUpdateWords < getZero()) {
                read = 0;
            }
            return read;
        } catch (Exception e) {
            e.printStackTrace();
            return read;
        } finally {
            readLock.unlock();
        }
    }

}

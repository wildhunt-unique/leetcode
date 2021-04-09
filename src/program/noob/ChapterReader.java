package program.noob;


/**
 * 记录每一章节的当前用户阅读数量，由一个段的数组实际去记录阅读数量，该章节的当前阅读数量总和等于每段阅读数量之和
 * 将阅读数量分成段的目的是减少每一章节锁的竞争。
 * 记录某一个用户正在读的时候，根据用户id的hash值取模获取对应的段，在对应的段上进行相加。
 *
 *
 *
 * @author 丁星（镜月）
 * @since 2021-04-08
 */
public class ChapterReader {
    private Segment[] segments;
    private Segment[] words;

    private int size;

    public ChapterReader(int size) {
        this.size = size;
    }

    public synchronized void initSegments() {
        this.segments = new Segment[size];
        for (int i = 0; i < size; i++) {
            segments[i] = new Segment();
        }
    }


    public void onRead(Long buyerId) {
        if (null == segments) {
            this.initSegments();
        }

        int index = buyerId.hashCode() & (size - 1);
        segments[index].onRead();
    }

    public void unRead(Long buyerId) {
        if (null == segments) {
            this.initSegments();
        }
        int index = buyerId.hashCode() & (size - 1);
        segments[index].unRead();
    }

    public int getRead() {
        if (null == segments) {
            return 0;
        } else {
            int total = 0;
            for (Segment segment : segments) {
                if (null != segment) {
                    total += segment.getReads();
                }
            }
            return total;
        }
    }
}

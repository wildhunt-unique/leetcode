package program.noob;

import java.util.Collection;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author 丁星（镜月）
 * @since 2021-04-08
 */
public class BookRead {
    private Long id;

    public BookRead(Long id) {
        this.id = id;
    }

    private Map<Long, ChapterReader> chapterReaderMap = new ConcurrentHashMap<>();

    public void onRead(Long buyerId, Long chapterId) {
        ChapterReader chapterReader = chapterReaderMap.get(chapterId);
        if (null == chapterId) {
            chapterReader = new ChapterReader(10);
            chapterReaderMap.put(chapterId, chapterReader);
        }
        chapterReader.onRead(buyerId);
    }

    public void unRead(Long buyerId, Long chapterId) {
        ChapterReader chapterReader = chapterReaderMap.get(chapterId);
        if (null != chapterId) {
            chapterReader.unRead(buyerId);
        }
    }

    public int getChapterReads(Long chapterId) {
        ChapterReader chapterReader = chapterReaderMap.get(chapterId);
        return null == chapterReader ? 0 : chapterReader.getRead();
    }

    public int getReader() {
        Collection<ChapterReader> values = chapterReaderMap.values();
        return values.stream().mapToInt(ChapterReader::getRead).sum();
    }

}

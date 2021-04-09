package program.noob;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author 丁星（镜月）
 * @since 2021-04-08
 */
public class StandonClinent implements Client {

    Map<Long, BookRead> idToBook = new ConcurrentHashMap<>();

    @Override
    public int getBookReads(Long bookId) {
        BookRead bookRead = idToBook.get(bookId);
        return bookRead == null ? 0 : bookRead.getReader();
    }

    @Override
    public int getChapterReads(Long bookId, Long chapterId) {
        BookRead bookRead = idToBook.get(bookId);
        return bookRead == null ? 0 : bookRead.getChapterReads(chapterId);
    }

    @Override
    public void onRead(Long buyerId, Long bookId, Long chapterId) {
        BookRead bookRead = idToBook.get(bookId);
        if (null == bookRead) {
            bookRead = new BookRead(bookId);
            idToBook.put(bookId, bookRead);
        }
        bookRead.onRead(buyerId, chapterId);
    }

    @Override
    public void unRead(Long buyerId, Long bookId, Long chapterId) {
        BookRead bookRead = idToBook.get(bookId);
        if (null != bookRead) {
            bookRead.unRead(buyerId,chapterId);
        }

    }
}

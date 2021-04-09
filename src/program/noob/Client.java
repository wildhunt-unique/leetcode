package program.noob;

/**
 * @author 丁星（镜月）
 * @since 2021-04-08
 */
public interface Client {
    int getBookReads(Long bookId);

    int getChapterReads(Long bookId, Long chapterId);

    void onRead(Long buyerId, Long bookId, Long chapterId);

    void unRead(Long buyerId, Long bookId, Long chapterId);
}

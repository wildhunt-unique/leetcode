package program.noob;

/**
 * 3. 假设每次请求的rt时间为x ms，则每秒单线程可请求 1000/x 次，
 *
 * @author 丁星（镜月）
 * @since 2021-04-08
 */
public class ClusterClient implements Client {
    Client[] list;

    public ClusterClient(Client[] list) {
        this.list = list;
    }

    @Override
    public int getBookReads(Long bookId) {
        return getClinet(bookId).getBookReads(bookId);
    }

    @Override
    public int getChapterReads(Long bookId, Long chapterId) {
        return getClinet(bookId).getChapterReads(bookId, chapterId);
    }

    @Override
    public void onRead(Long buyerId, Long bookId, Long chapterId) {
        getClinet(bookId).onRead(buyerId, bookId, chapterId);
    }

    @Override
    public void unRead(Long buyerId, Long bookId, Long chapterId) {
        getClinet(bookId).unRead(buyerId, bookId, chapterId);

    }

    private Client getClinet(Long bookId) {
        int index = bookId.hashCode() & (list.length - 1);
        return list[index];
    }
}

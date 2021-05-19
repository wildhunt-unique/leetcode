package program;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

/**
 * @author 丁星（镜月）
 * @since 2021-04-07
 */
public class LRUCache {
    private int max;
    private LinkedList<Integer> queen;
    private Map<Integer, Integer> cache;

    public static void main(String[] args) {
        System.out.println(String.format("%x", 67111));
    }

    public LRUCache(int max) {
        this.max = max;
        queen = new LinkedList<>();
        cache = new HashMap<>();
    }

    public Integer get(int key) {
        Integer rst = cache.get(key);
        return rst == null ? -1 : rst;
    }

    public void put(int key, int val) {
        Integer exist = cache.get(key);
        if (null != exist) {
            queen.remove(key);
            queen.addLast(key);
        } else {
            if (queen.size() >= max) {
                Integer first = queen.pollFirst();
                cache.remove(first);
            }
            cache.put(key, val);
            queen.addLast(key);
        }
    }
}

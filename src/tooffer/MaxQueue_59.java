package tooffer;

import sun.util.resources.es.CurrencyNames_es_UY;

import java.util.LinkedList;

/**
 * @author 丁星（镜月）
 * @since 2021-04-02
 */
public class MaxQueue_59 {
    private LinkedList<Integer> val;
    private LinkedList<Integer> max;

    public MaxQueue_59() {
        val = new LinkedList<>();
        max = new LinkedList<>();
    }

    public int max_value() {
        Integer first = max.getFirst();
        return first == null ? -1 : first;
    }

    public void push_back(int value) {

    }

    public int pop_front() {
        return 1;
    }
}

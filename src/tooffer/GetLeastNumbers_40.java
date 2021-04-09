package tooffer;
/*
输入整数数组 arr ，找出其中最小的 k 个数。例如，输入4,5,1,6,2,7,3,8这8个数字，则最小的4个数字是1,2,3,4。

 

示例 1：

输入：arr = [3,2,1], k = 2
输出：[1,2] 或者 [2,1]
示例 2：

输入：arr = [0,1,2,1], k = 1
输出：[0]
 

限制：

0 <= k <= arr.length <= 10000
0 <= arr[i] <= 10000

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/zui-xiao-de-kge-shu-lcof
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * @author 丁星（镜月）
 * @since 2021-04-08
 */
public class GetLeastNumbers_40 {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new GetLeastNumbers_40().getLeastNumbers(
                new int[]{4, 5, 1, 6, 2, 7, 3, 8}, 3
        )));
    }

    public int[] getLeastNumbers(int[] arr, int k) {
        return withHeap(arr, k);
    }

    private int[] withQuickSort(int[] arr, int k) {
        return null;
    }

    private int[] withHeap(int[] arr, int k) {
        PriorityQueue<Integer> heap = new PriorityQueue<>(k, (i1, i2) -> Integer.compare(i2, i1));

        for (int i : arr) {
            if (heap.isEmpty() || heap.size() < k || i < heap.peek()) {
                heap.offer(i);
            }
            if (heap.size() > k) {
                heap.poll();
            }
        }
        int[] rst = new int[heap.size()];
        int i = 0;
        for (Integer integer : heap) {
            rst[i++] = integer;
        }
        return rst;
    }
}

package tooffer;

/*
数组中有一个数字出现的次数超过数组长度的一半，请找出这个数字。

 

你可以假设数组是非空的，并且给定的数组总是存在多数元素。

 

示例 1:

输入: [1, 2, 3, 2, 2, 2, 5, 4, 2]
输出: 2
 

限制：

1 <= 数组长度 <= 50000

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/shu-zu-zhong-chu-xian-ci-shu-chao-guo-yi-ban-de-shu-zi-lcof
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
/**
 * @author 丁星（镜月）
 * @since 2021-04-07
 */
@SuppressWarnings("all")
public class MajorityElement_39 {
    public static void main(String[] args) {
        int[] ints = {1, 2, 2, 5, 2, 2, 3};
        System.out.println(new MajorityElement_39().majorityElement(ints));
    }

    public int majorityElement(int[] nums) {
        int vo = 0;
        int card = nums[0];
        for (int num : nums) {
            if (vo == 0) {
                card = num;
            }
            vo += card == num ? 1 : -1;
        }
        return card;
    }
}

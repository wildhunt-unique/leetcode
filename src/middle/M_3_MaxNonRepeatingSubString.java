package middle;

import java.util.HashMap;
import java.util.Map;

/**
 * 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
 *
 * @author dx DingXing
 * @since 2021-01-26
 */
public class M_3_MaxNonRepeatingSubString {
    public static void main(String[] args) {
        String s = "au";
        System.out.println(new M_3_MaxNonRepeatingSubString().lengthOfLongestSubstring(s));
    }

    /**
     * 滑动窗口，记录前后两个区间
     *
     * @param s String
     * @return int
     */
    public int lengthOfLongestSubstring(String s) {
        char[] chars = s.toCharArray();
        if (chars.length <= 1) {
            return chars.length;
        }
        Map<Character, Integer> map = new HashMap<>();
        int begin = 0;
        int max = 0;
        map.put(chars[begin], begin);
        for (int end = 1; end < chars.length; end++) {
            Integer lastIndex = map.get(chars[end]);
            if (null != lastIndex && lastIndex >= begin) {
                begin = lastIndex + 1;
            }

            map.put(chars[end], end);
            int now = end - begin + 1;
            max = now > max ? now : max;
        }

        return max;
    }

}

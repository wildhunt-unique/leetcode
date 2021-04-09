package middle;

/**
 * @author dx DingXing
 * @since 2021-01-26
 */
public class M_5_LongestPalindrome {


    public static void main(String[] args) {

        String s = "";
        for (int i = 0; i < 10; i++) {
            s = s + "xcccxaxcccxaxcccxaxcccxaxcccxaxcccxaxcccxaxcccxaxccc";
        }
        long l = System.currentTimeMillis();
        System.out.println(new M_5_LongestPalindrome().longestPalindrome(s));
        long l1 = System.currentTimeMillis();
        System.out.println(l1 - l);
    }

    public String longestPalindrome(String s) {
        char[] chars = s.toCharArray();
        String rest = s.substring(0, 1);
        for (int i = 0; i < chars.length; i++) {
            int begin = 0, end = 0;
            for (int head = i, next = i; head >= 0 && next < chars.length; next++, head--) {
                if (chars[head] == chars[next]) {
                    begin = head;
                    end = next;
                } else {
                    break;
                }
            }
            String cur = s.substring(begin, end + 1);
            rest = cur.length() > rest.length() ? cur : rest;

            begin = 0;
            end = 0;
            for (int head = i, next = i + 1; head >= 0 && next < chars.length; next++, head--) {
                if (chars[head] == chars[next]) {
                    begin = head;
                    end = next;
                } else {
                    break;
                }
            }

            cur = s.substring(begin, end + 1);
            rest = cur.length() > rest.length() ? cur : rest;
        }

        return rest;
    }

}

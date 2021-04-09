package middle;

import java.util.LinkedList;
import java.util.List;

/**
 * @author dx DingXing
 * @since 2021-01-28
 */
public class M_6_ZConvert {
    public static void main(String[] args) {
        String s = "";
        for (int i = 0; i < 10000; i++) {
            s = s + "123424wxf3rty2rte3r34t";
        }
        long l = System.currentTimeMillis();
        System.out.println(new M_6_ZConvert().convert(s, 3));
        long l1 = System.currentTimeMillis();
        System.out.println(l1 - l);
    }

    public String convert(String s, int numRows) {
        char[] chars = s.toCharArray();
        List[] rest = new List[numRows];
        if (chars.length <= 1) {
            return s;
        }
        for (int i = 0; i < rest.length; i++) {
            rest[i] = new LinkedList<>();
        }


        boolean dict = false;
        int begin = 0;
        for (int i = 0; i < chars.length; i++) {
            rest[begin].add(chars[i]);
            if (i % (numRows - 1) == 0) {
                dict = !dict;
            }
            if (dict) {
                begin++;
            } else {
                begin--;
            }
        }

        StringBuilder sb = new StringBuilder();
        for (List<Character> characters : rest) {
            for (Character next : characters) {
                sb.append(next);
            }
        }

        return sb.toString();
    }
}

package tooffer;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/**
 * 请设计一个函数，用来判断在一个矩阵中是否存在一条包含某字符串所有字符的路径。路径可以从矩阵中的任意一格开始，每一步可以在矩阵中向左、右、上、下移动一格。
 * 如果一条路径经过了矩阵的某一格，那么该路径不能再次进入该格子。例如，在下面的3×4的矩阵中包含一条字符串“bfce”的路径（路径中的字母用加粗标出）。
 * <p>
 * [["a","b","c","e"],
 * ["s","f","c","s"],
 * ["a","d","e","e"]]
 * <p>
 *
 * @author dx DingXing
 * @since 2021-03-13
 */
public class ExistPath {
    public static void main(String[] args) {

    }

    public boolean exist(char[][] board, String word) {
        char[] chars = word.toCharArray();
        if (word.isEmpty() || board == null || board.length == 0 || board[0].length == 0) {
            return false;
        }
        Set<Character> set = new HashSet(Collections.singleton(chars));
        char begin = chars[0];

//        for (int i = 0; i < board.length; i++) {
//            for (int j = 0; j < board[i].length; j++) {
//                if (!set.contains(board[i][j])) {
//                    set[][]
//                }
//                if (board[i][j] == begin) {
//                    beginI = i;
//                    beginJ = j;
//                }
//            }
//        }

        return false;
    }
}

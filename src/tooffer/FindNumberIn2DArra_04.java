package tooffer;

/**
 * @author dx DingXing
 * @since 2021-03-13
 */
public class FindNumberIn2DArra_04 {


    public static void main(String[] args) {

        int matrix[][] = new int[][]{
                {1, 4, 7, 11, 15},
                {2, 5, 8, 12, 19},
                {3, 6, 9, 16, 22},
                {10, 13, 14, 17, 24},
                {18, 21, 23, 26, 30}
        };
        System.out.println(new FindNumberIn2DArra_04().findNumberIn2DArray(matrix, 27));
    }

    public boolean findNumberIn2DArray(int[][] matrix, int target) {
        if (matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }

        int n = matrix.length;
        int m = matrix[0].length;

        int[][] arrived = new int[n][m];
        return found(0, 0, n, m, target, matrix, arrived, new boolean[]{false});
    }

    private boolean found(int i, int j, int n, int m, int tofind, int[][] matrix, int[][] arrived, boolean[] finded) {
        if (arrived[i][j] == 1 || finded[0]) {
            return false;
        } else {
            arrived[i][j] = 1;
        }

        if (matrix[i][j] == tofind) {
            finded[0] = true;
            return true;
        } else if (matrix[i][j] > tofind) {
            return false;
        }

        if (i + 1 < n) {
            if (found(i + 1, j, n, m, tofind, matrix, arrived, finded)) {
                return true;
            }
        }
        if (j + 1 < m) {
            if (found(i, j + 1, n, m, tofind, matrix, arrived, finded)) {
                return true;
            }
        }

        return false;
    }
}


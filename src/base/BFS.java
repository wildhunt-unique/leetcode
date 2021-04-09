package base;

import java.util.LinkedList;

import static base.BFS.Node.valueOf;

/**
 * @author dx DingXing
 * @since 2021-03-09
 */
public class BFS {
    public static void main(String[] args) {
        Node[][] func = func(5);

        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                System.out.print(func[i][j] + "\t");
            }
            System.out.println();
        }
    }

    private static Node[][] func(int n) {
        int[][] arv = new int[n][n];
        Node[][] from = new Node[n][n];

        LinkedList<Node> stack = new LinkedList<>();
        stack.addLast(valueOf(0, 0));
        while (!stack.isEmpty()) {
            Node last = stack.getLast();
            stack.remove(last);
            from[last.x][last.y] = last;

            // 上
            if (last.x - 1 > 0 && arv[last.x - 1][last.y] == 0) {
                Node up = valueOf(last.x - 1, last.y);
                arv[last.x - 1][last.y] = 1;
                from[last.x - 1][last.y] = last;
                stack.addLast(up);
            }

            // 下
            if ((last.x) < n - 1 && arv[last.x + 1][last.y] == 0) {
                Node up = valueOf(last.x + 1, last.y);
                arv[last.x + 1][last.y] = 1;
                from[last.x + 1][last.y] = last;
                stack.addLast(up);
            }

            // 上
            if (last.y - 1 > 0 && arv[last.x][last.y - 1] == 0) {
                Node up = valueOf(last.x, last.y - 1);
                arv[last.x][last.y - 1] = 1;
                from[last.x][last.y - 1] = last;
                stack.addLast(up);
            }


            // 下
            if ((last.y) < n - 1 && arv[last.x][last.y + 1] == 0) {
                Node up = valueOf(last.x, last.y + 1);
                arv[last.x][last.y + 1] = 1;
                from[last.x][last.y + 1] = last;
                stack.addLast(up);
            }
        }


        return from;
    }

    static class Node {
        int x;
        int y;

        static Node valueOf(int x, int y) {
            Node n = new Node();
            n.x = x;
            n.y = y;
            return n;
        }

        @Override
        public String toString() {
            return "(" + x + "," + y + ")";
        }
    }
}



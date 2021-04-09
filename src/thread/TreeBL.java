package thread;

import java.util.LinkedList;

/**
 * @author dx DingXing
 * @since 2021-03-10
 */
public class TreeBL {
    private LinkedList<Node> stack = new LinkedList<>();
    private LinkedList<Node> stack2 = new LinkedList<>();

    public static void main(String[] args) {
        Node A = new Node("A");
        Node B = new Node("B");
        Node C = new Node("C");

        Node D = new Node("D");
        Node E = new Node("E");
        Node F = new Node("F");
        Node G = new Node("G");


        A.left = B;
        A.right = C;
        B.right = D;
        B.left = E;
        C.left = F;
        C.right = G;

        new TreeBL().printZ(A);
    }

    void printZ(Node node) {
        stack.add(node);


        while (!stack2.isEmpty() || !stack.isEmpty()) {
            while (!stack.isEmpty()) {
                Node first = stack.getLast();
                stack.remove(first);
                System.out.println(first.value);
                if (null != first.left) {
                    stack2.add(first.left);
                }

                if (null != first.right) {
                    stack2.add(first.right);
                }
            }

            while (!stack2.isEmpty()) {
                Node first = stack2.getLast();
                stack2.remove(first);
                System.out.println(first.value);
                if (null != first.left) {
                    stack.add(first.left);
                }

                if (null != first.right) {
                    stack.add(first.right);
                }
            }
        }

    }

    /**
     * 层序
     *
     * @param node
     */
    void print(Node node) {
        stack.add(node);


        while (!stack.isEmpty()) {
            Node first = stack.getFirst();
            stack.remove(first);
            System.out.println(first.value);

            if (null != first.left) {
                stack.add(first.left);
            }

            if (null != first.right) {
                stack.add(first.right);
            }
        }
    }

    public static class Node {
        String value;
        Node left;
        Node right;

        public Node(String value) {
            this.value = value;
        }

        public Node(String value, Node left, Node right) {
            this.value = value;
            this.left = left;
            this.right = right;
        }
    }

}

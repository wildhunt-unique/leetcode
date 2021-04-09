package thread;
import java.util.Scanner;
import java.util.LinkedList;

public class Main {
    public static void main(String[] args) {
        TreeNode A = new TreeNode("A");
        TreeNode B = new TreeNode("B");
        TreeNode C = new Main.TreeNode("C");
        TreeNode D = new Main.TreeNode("D");
        TreeNode E = new Main.TreeNode("E");
        TreeNode F = new Main.TreeNode("F");
        TreeNode G = new Main.TreeNode("G");

        A.left = B;
        A.right = C;
        B.left = D;
        B.right = E;
        C.left = F;
        C.right = G;

        printTreeS(A);

    }

    public static class TreeNode{
        TreeNode left;
        TreeNode right;
        String val;


        public TreeNode(String val){
            this.val=val;
        }
    }

    public static void printTreeS(TreeNode head){
        if(null == head ){
            return;
        }

        LinkedList<TreeNode> stack1 = new LinkedList<>();
        LinkedList<TreeNode> stack2 = new LinkedList<>();

        stack1.add(head);

        while(!stack1.isEmpty() || !stack2.isEmpty()){
            while(!stack1.isEmpty()){
                TreeNode s1 =  stack1.getFirst();
                System.out.println(s1.val);
                stack1.remove(s1);
                if(s1.left!=null){
                    stack2.add(s1.left);
                }
                if(s1.right != null){
                    stack2.add(s1.right);
                }

            }

            while(!stack2.isEmpty()){
                TreeNode s2 = stack2.getLast();
                System.out.println(s2.val);
                stack2.remove(s2);
                if(s2.right != null){
                    stack1.add(s2.right);
                }
                if(s2.left != null){
                    stack1.add(s2.left);
                }

            }
        }

    }
}
package tooffer;

import base.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
/*
输入一棵二叉树和一个整数，打印出二叉树中节点值的和为输入整数的所有路径。从树的根节点开始往下一直到叶节点所经过的节点形成一条路径。

 

示例:
给定如下二叉树，以及目标和 target = 22，

              5
             / \
            4   8
           /   / \
          11  13  4
         /  \    / \
        7    2  5   1
返回:

[
   [5,4,11,2],
   [5,8,4,5]
]

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/er-cha-shu-zhong-he-wei-mou-yi-zhi-de-lu-jing-lcof
 */

/**
 * @author 丁星（镜月）
 * @since 2021-04-07
 */
public class PathSum_34 {
    public static void main(String[] args) {
        TreeNode _5 = new TreeNode(5);
        TreeNode _4 = new TreeNode(4);
        TreeNode _11 = new TreeNode(11);
        TreeNode _7 = new TreeNode(7);
        TreeNode _2 = new TreeNode(2);

        TreeNode _8 = new TreeNode(8);
        TreeNode _13 = new TreeNode(13);
        TreeNode _l4 = new TreeNode(4);
        TreeNode _l5 = new TreeNode(5);
        TreeNode _1 = new TreeNode(1);

        _5.left = _4;
        _4.left = _11;
        _11.left = _7;
        _11.right = _2;

        _5.right = _8;
        _8.left = _13;
        _8.right = _l4;
        _l4.left = _l5;
        _l4.right = _1;

        TreeNode root = new TreeNode(-2);
        root.right = new TreeNode(-3);

        System.out.println(new PathSum_34().pathSum(root, -5));

    }

    private LinkedList<Integer> stack = new LinkedList<>();
    private List<List<Integer>> rst = new ArrayList<>();
    private int stackSum = 0;

    public List<List<Integer>> pathSum(TreeNode root, int target) {
        if (root == null) {
            return new ArrayList<>();
        }

        dfs(root, target);
        return rst;
    }

    private void dfs(TreeNode root, int target) {
        if (root == null) {
            return;
        }
        stack.addLast(root.val);
        this.stackSum += root.val;

        if (this.stackSum == target && root.right == null && root.left == null) {
            rst.add(new ArrayList<>(stack));
        }

        dfs(root.left, target);
        dfs(root.right, target);

        this.stackSum -= root.val;
        stack.pollLast();
    }


}

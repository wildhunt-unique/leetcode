package tooffer;

import base.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author dx DingXing
 * @since 2021-03-13
 */
public class BuildTree_07 {

    public static void main(String[] args) {

        int[] i1 = new int[]{3, 9, 20, 15, 7};


        int[] i2 = new int[]{9, 3, 15, 20, 7};
        TreeNode treeNode = new BuildTree_07().buildTree(i1, i2);
        System.out.println(treeNode.toString());
    }

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int length;
        if (preorder == null || (length = preorder.length) == 0) {
            return null;
        }

        Map<Integer, Integer> valToPrePos = new HashMap<>(length);
        for (int i = 0; i < length; i++) {
            valToPrePos.put(preorder[i], i);
        }

        return buildTree(inorder, valToPrePos, 0, length - 1);
    }

    public TreeNode buildTree(int[] inorder, Map<Integer, Integer> valToPrePos, int low, int height) {
        if (low >= height) {
            return new TreeNode(inorder[low]);
        }
        int minPosInPre = height + 1;
        int minPosInIn = 0;
        for (int i = low; i <= height; i++) {
            Integer posInPre = valToPrePos.get(inorder[i]);
            if (posInPre < minPosInPre) {
                minPosInPre = posInPre;
                minPosInIn = i;
            }
        }
        TreeNode node = new TreeNode(inorder[minPosInIn]);
        if (minPosInIn != low) {
            node.left = buildTree(inorder, valToPrePos, low, minPosInIn - 1);
        }
        if (minPosInIn != height) {
            node.right = buildTree(inorder, valToPrePos, minPosInIn + 1, height);
        }
        return node;
    }
}

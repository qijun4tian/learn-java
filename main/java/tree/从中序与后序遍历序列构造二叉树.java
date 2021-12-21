package tree;

import java.util.Arrays;

/**
 * @Author:qijun
 * @Description
 * @Date 22:33 2021/12/21
 */
public class 从中序与后序遍历序列构造二叉树 {

    public static TreeNode buildTree(int[] inorder, int[] postorder) {
        if (inorder.length == 0 && postorder.length == 0) {
            return null;
        }
        if (inorder.length == 1) {
            TreeNode treeNode = new TreeNode(inorder[0]);
            treeNode.left = null;
            treeNode.right = null;
            return treeNode;
        }
        if (postorder.length == 1) {
            TreeNode treeNode = new TreeNode(postorder[0]);
            treeNode.left = null;
            treeNode.right = null;
            return treeNode;
        }

        int rootVal = postorder[postorder.length - 1];
        TreeNode root = new TreeNode(rootVal);
        int index1 = getSubArray(inorder, root.val);
        int[] inorderLeft = Arrays.copyOfRange(inorder, 0, index1);
        int[] inorderRight = Arrays.copyOfRange(inorder, index1 + 1, inorder.length);

        int[] postorderLeft = new int[0];
        int[] postorderRight = new int[0];
        if (inorderLeft.length != 0) {
            int index2 = getSubArray(postorder, inorderLeft[inorderLeft.length - 1]);

            postorderLeft = Arrays.copyOfRange(postorder, 0, index2 + 1);
            postorderRight = Arrays.copyOfRange(postorder, index2 + 1, postorder.length - 1);
        }
        root.left = buildTree(inorderLeft, postorderLeft);
        root.right = buildTree(inorderRight, postorderRight);
        return root;

    }


    public static int getSubArray(int[] inorder, int value) {
        int k = 0;
        for (int i = 0; i < inorder.length; i++) {
            if (value == inorder[i]) {
                k = i;
                break;
            }
        }
        return k;

    }

    public static void main(String[] args) {
        int[] inorder = {2, 3, 1};
        int[] postorder = {3, 2, 1};
        TreeNode treeNode = buildTree(inorder, postorder);
        System.out.println("111");

    }


}

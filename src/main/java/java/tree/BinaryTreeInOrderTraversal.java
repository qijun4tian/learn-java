package java.tree;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 二叉树中序遍历,也叫中根遍历
 * 先遍历左节点，再遍历中节点，最后右节点
 */
public class BinaryTreeInOrderTraversal {

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }

        if (root.left != null) {
            inorderTraversalRecruise(result, root.left);
        }
        result.add(root.val);
        if (root.right != null) {
            inorderTraversalRecruise(result, root.right);
        }
        return result;
    }

    public static void inorderTraversalRecruise(List<Integer> result, TreeNode treeNode) {
        if (treeNode == null) {
            return;
        }
        if (treeNode.left != null) {
            inorderTraversalRecruise(result, treeNode.left);
        }
        result.add(treeNode.val);
        if (treeNode.right != null) {
            inorderTraversalRecruise(result, treeNode.right);
        }
    }

    /**
     * 改进的写法
     *
     * @param root
     * @return
     */
    public static void inorderTraversalImprove(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        inorderTraversalRecruise(result, root);
        String printString = result.stream().map(Object::toString).collect(Collectors.joining());
        System.out.println(printString);

    }

    /**
     *     1
     *    /  \
     *   2     5
     *  /\    /\
     * 3  4  6  7
     *
     * @param args
     */

    public static void main(String[] args) {
        TreeNode treeNode1 = new TreeNode(1);
        TreeNode treeNode2 = new TreeNode(2);
        TreeNode treeNode3 = new TreeNode(3);
        TreeNode treeNode4 = new TreeNode(4);
        TreeNode treeNode5 = new TreeNode(5);
        TreeNode treeNode6 = new TreeNode(6);
        TreeNode treeNode7 = new TreeNode(7);

        treeNode1.left = treeNode2;
        treeNode1.right = treeNode5;
        treeNode2.left = treeNode3;
        treeNode2.right = treeNode4;
        treeNode5.left = treeNode6;
        treeNode5.right = treeNode7;
        inorderTraversalImprove(treeNode1);


    }

    /**
     * 迭代法
     *
     * @param root
     * @return
     */
    public List<Integer> inorderTraversal2(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        Deque<TreeNode> stack = new LinkedList<>();
        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            result.add(root.val);
            root = root.right;
        }
        return result;
    }

}

package tree;

import java.util.function.DoublePredicate;

/**
 * @Author:qijun
 * @Description
 * @Date 23:32 2021/12/24
 */
public class 二叉树的最近公共祖先 {
    private int deep1 = 0;
    private int deep2 = 0;

    private TreeNode root1;
    private TreeNode root2;

    private int deep = 0;

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        deep++;
        if (root == null) {
            return null;
        }
        if (root.val == p.val) {
            deep1 = deep;
            root1 = root;
        }
        if (root.val == q.val) {
            deep2 = deep;
            root2 = root;
        }

        if ((root.left != null && root.left.val == p.val) || (root.right != null &&
                root.right.val == p.val)) {

            deep1 = deep;
            root1 = root;
        }
        if ((root.left != null && root.left.val == q.val) || (root.right != null &&
                root.right.val == q.val)) {

            deep2 = deep;
            root2 = root;
        }
        if (root1 == null && root2 == null) {
            return root;
        }
        if (root1 != null && root2 != null) {
            return deep1 < deep2 ? root1 : root2;
        }
        if (root.left != null) {
            TreeNode treeNode = lowestCommonAncestor(root.left, p, q);
            if (treeNode != null) {
                return treeNode;
            }
        }
        if (root.right != null) {
            TreeNode treeNode = lowestCommonAncestor(root.right, p, q);
            if (treeNode != null) {
                return treeNode;
            }
        }
        return null;
    }


}

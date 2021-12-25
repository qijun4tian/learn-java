package tree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.DoublePredicate;

/**
 * @Author:qijun
 * @Description
 * @Date 23:32 2021/12/24
 */
public class 二叉树的最近公共祖先 {

    private static Map<TreeNode, TreeNode> map = new HashMap<>();


    public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        dfs(null, root, p, q);
        List<TreeNode> treeNodes1 = new ArrayList<>();
        List<TreeNode> treeNodes2 = new ArrayList<>();
        TreeNode treeNode1 = p;
        TreeNode treeNode2 = q;
        while (treeNode1 != null) {
            treeNodes1.add(treeNode1);
            treeNode1 = map.get(treeNode1);
        }
        while (treeNode2 != null) {
            treeNodes2.add(treeNode2);
            treeNode2 = map.get(treeNode2);
        }
        for (TreeNode node : treeNodes1) {
            for (TreeNode treeNode : treeNodes2) {
                if (node == treeNode) {
                    return node;
                }
            }
        }
        return null;

    }

    public static void dfs(TreeNode last, TreeNode node, TreeNode p, TreeNode q) {
        if (node == null) {
            return;
        }
        map.put(node, last);

        if (map.containsKey(p) && map.containsKey(q)) {
            return;
        }
        dfs(node, node.left, p, q);
        dfs(node, node.right, p, q);
    }

    public static void main(String[] args) {
        TreeNode treeNode3 = new TreeNode(3);
        TreeNode treeNode5 = new TreeNode(5);
        TreeNode treeNode1 = new TreeNode(1);
        TreeNode treeNode6 = new TreeNode(6);
        TreeNode treeNode2 = new TreeNode(2);
        TreeNode treeNode0 = new TreeNode(0);
        TreeNode treeNode8 = new TreeNode(8);
        TreeNode treeNode7 = new TreeNode(7);
        TreeNode treeNode4 = new TreeNode(4);
        treeNode3.left = treeNode5;
        treeNode3.right = treeNode1;
        treeNode5.left = treeNode6;
        treeNode5.right = treeNode2;
        treeNode1.left = treeNode0;
        treeNode1.right = treeNode8;
        treeNode2.left = treeNode7;
        treeNode2.right = treeNode4;
        TreeNode treeNode = lowestCommonAncestor(treeNode3, treeNode5, treeNode4);
        System.out.println("111");


    }


}

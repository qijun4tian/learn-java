package java.tree;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author:qijun
 * @Description
 * @Date 10:51 2021/12/26
 */
public class 二叉树的序列化与反序列化 {


    // Encodes a tree to a single string.
    public static String serialize(TreeNode root) {
        if (root == null) {
            return "";
        }
        List<String> s = new ArrayList<>();
        List<TreeNode> stack = new ArrayList<>();
        stack.add(root);
        while (stack.size() != 0) {
            boolean isAllNull = true;
            List<TreeNode> temp = new ArrayList<>();
            int lastNotNull = 0;
            for (int i = 0; i < stack.size(); i++) {
                TreeNode treeNode = stack.get(i);
                if (treeNode == null) {
                    s.add("null");
                } else {
                    lastNotNull = i;
                    s.add(String.valueOf(treeNode.val));
                    if (treeNode.left == null) {
                        temp.add(null);
                    } else {
                        isAllNull = false;
                        temp.add(treeNode.left);
                    }
                    if (treeNode.right == null) {
                        temp.add(null);
                    } else {
                        isAllNull = false;
                        temp.add(treeNode.right);
                    }
                }
            }
            System.out.println(String.join(",", s));

            if (isAllNull) {
                s = s.subList(0, s.size() - (stack.size() - 1 - lastNotNull));
                break;
            }
            stack = temp;
        }
        return String.join(",", s);

    }

    // Decodes your encoded data to tree.
    public static TreeNode deserialize(String data) {
        if (data == null || data.length() == 0) {
            return null;
        }
        String[] split = data.split(",");
        int length = split.length;
        TreeNode head = new TreeNode(Integer.parseInt(split[0]));
        List<TreeNode> treeNodes = new ArrayList<>();
        treeNodes.add(head);
        int k = 0;
        for (int i = 0; i < length; i++) {
            TreeNode treeNode = treeNodes.get(i);
            if (treeNode != null) {
                if ((k * 2 + 1) < length) {

                    treeNode.left = buildNode(split[k * 2 + 1]);
                    treeNodes.add(treeNode.left);
                }
                if ((k * 2 + 2) < length) {
                    treeNode.right = buildNode(split[k * 2 + 2]);
                    treeNodes.add(treeNode.right);
                }
                k++;
            }
        }
        return head;

    }

    public static TreeNode buildNode(String s) {
        if ("null".equals(s)) {
            return null;
        } else {
            return new TreeNode(Integer.parseInt(s));
        }

    }

    public static void main(String[] args) {
        String s = "1,2,3,null,null,4,5,6,7";
        TreeNode deserialize = deserialize(s);
        System.out.println(serialize(deserialize));
        System.out.println("1");

    }
}

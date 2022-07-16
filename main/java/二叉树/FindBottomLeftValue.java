package 二叉树;

import tree.TreeNode;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author qijun
 * @Description
 * @Date 20:44 2022/6/22
 */
public class FindBottomLeftValue {

    public static int findBottomLeftValue(TreeNode root) {
        Deque<TreeNode> queue = new LinkedList();

        queue.add(root);
        int leastVal = root.val;
        while(queue.size() != 0){
            int size = queue.size();
            // System.out.println("size=" + size);
            for(int i =0; i< size; i++){
                TreeNode node = queue.poll();
                if(i == 0){
                    leastVal = node.val;
                }
                if(node.left != null){


                    // System.out.println("node left =" + node.left.val);
                    queue.add(node.left);
                }
                if(node.right != null){
                    //   System.out.println("node right=" + node.right.val);
                    queue.add(node.right);
                }


            }
        }

        return leastVal;
    }

    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(1);
        TreeNode treeNode1 = new TreeNode(2);

        TreeNode treeNode2 = new TreeNode(3);

        TreeNode treeNode3 = new TreeNode(4);

        treeNode.left = treeNode1;
        treeNode.right = treeNode2;

        treeNode1.left = treeNode3;
        findBottomLeftValue(treeNode);



    }
}

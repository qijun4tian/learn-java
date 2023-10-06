package 队列和广度搜索;

import tree.TreeNode;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author qijun
 * @since 2023/6/21
 */
public class MaxWidth {



    public static int widthOfBinaryTree(TreeNode root) {
        if(root == null){
            return 0;
        }
        int result = 1;
        Deque<TreeNode> queue = new LinkedList();
        Deque<Integer> indexQueue = new LinkedList();
        indexQueue.add(0);
        queue.add(root);
        while(queue.size() != 0){
            int size = queue.size();
            boolean isFirst = false;
            int begin = 0;
            int end = 0;
            for(int i=0; i< size; i++){
                TreeNode node = queue.poll();
                Integer index = indexQueue.poll();
                if(node.left != null){
                    if(!isFirst){
                        isFirst = true;
                        begin = 2*index;
                        end = 2*index;
                    }else{
                        end = 2*index;

                    }
                    queue.add(node.left);
                    indexQueue.add(2*index);
                }
                if(node.right != null){
                    if(!isFirst){
                        isFirst = true;
                        begin = 2*index + 1;
                        end = 2*index + 1;
                    }else{
                        end = 2*index + 1;

                    }
                    queue.add(node.right);
                    indexQueue.add(2*index+1);
                }
            }
            result = Math.max(end-begin +1,result);

        }
        return result;

    }

    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(1);
        TreeNode treeNode1 = new TreeNode(2);
        TreeNode treeNode2 = new TreeNode(3);
        treeNode.left = treeNode1;
        treeNode.right = treeNode2;

        System.out.println(widthOfBinaryTree(treeNode));

    }
}

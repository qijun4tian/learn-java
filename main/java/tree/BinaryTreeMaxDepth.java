package tree;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 二叉树最大深度
 * @Author:qijun
 * @Description https://leetcode-cn.com/leetbook/read/top-interview-questions-easy/xnd69e/
 * @Date 21:56 2021/11/15
 */
public class BinaryTreeMaxDepth {
    public int maxDepth(TreeNode root) {
        if(root == null){
            return 0;
        }
        return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
    }


    public int maxDepth2(TreeNode root) {
        if (root == null)
            return 0;
        //创建一个队列
        Deque<TreeNode> deque = new LinkedList<>();
        deque.push(root);
        int count = 0;
        while (!deque.isEmpty()) {
            //每一层的个数
            int size = deque.size();
            while (size-- > 0) {
                TreeNode cur = deque.pop();
                if (cur.left != null)
                    deque.addLast(cur.left);
                if (cur.right != null)
                    deque.addLast(cur.right);
            }
            count++;
        }
        return count;
    }


}

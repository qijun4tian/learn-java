package tree;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * @Author:qijun
 * @Description
 * @Date 22:09 2021/11/15
 */
public class LevelOrder {
    int dept = 0;
    List<List<Integer>> result = new ArrayList<>();

    public List<List<Integer>> levelOrder(TreeNode root) {
        if(root == null){
            return null;
        }
        List<List<Integer>> result = new ArrayList<>();
        //创建一个队列
        Deque<TreeNode> deque = new LinkedList<>();
        deque.push(root);
        while (!deque.isEmpty()) {
            //每一层的个数
            int size = deque.size();
            List<Integer> list = new ArrayList<>();
            result.add(list);
            while (size-- > 0) {
                TreeNode cur = deque.pop();
                list.add(cur.val);
                if (cur.left != null)
                    deque.addLast(cur.left);
                if (cur.right != null)
                    deque.addLast(cur.right);
            }
        }
        return result;

    }
}

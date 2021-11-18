package tree;

import com.sun.org.apache.regexp.internal.REUtil;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * 二叉树是不是对称的
 * @Author:qijun
 * @Description https://leetcode-cn.com/leetbook/read/top-interview-questions-easy/xn7ihv/
 * @Date 22:32 2021/11/17
 */
public class IsSymmetric {

    public boolean isSymmetric(TreeNode root) {
        if(root == null){
            return true;
        }
        List<TreeNode> deque = new ArrayList<>();
        deque.add(root);
        return isSymmetric1(deque);

    }
    public boolean isSymmetric1(List<TreeNode> deque){
        int size = deque.size();
        if(deque.size() == 0){
            return true;
        }
        List<TreeNode> list = new ArrayList<>();
        for (int i = 0; i < (size +1) / 2; i++) {
            if(deque.get(i) == null || deque.get(size -1 -i) != null){
                return false;
            }
            if(deque.get(i) != null || deque.get(size -1 -i) == null){
                return false;
            }
            if(deque.get(i) != null &&  deque.get(size -1 -i) != null && deque.get(i).val != deque.get(size - 1- i).val){
                return false;
            }
            if(deque.get(i) != null &&  deque.get(size -1 -i) != null ){
                list.add(2*i,deque.get(i).left);
                list.add(2*i+1,deque.get(i).right);

                list.add(2*(size-1-i),deque.get(size- 1- i).left);
                list.add(2*(size-1-i)+1,deque.get(size- 1- i).right);
            }
        }
        return isSymmetric1(list);
    }





}

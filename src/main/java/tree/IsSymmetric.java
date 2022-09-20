package tree;

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
        return isSymmetricHelper(root.left,root.right);
    }




    public boolean isSymmetricHelper(TreeNode left, TreeNode right) {
        if((left == null && right != null) || (left != null && right == null)){
            return false;
        }
        if(left != null && right != null){
            if(left.val != right.val){
                return false;
            }else {
                return isSymmetricHelper(left.left,right.right) && isSymmetricHelper(left.right,right.left);
            }
        }

        return true;



    }





}
